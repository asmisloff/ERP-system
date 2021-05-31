package ru.geekbrains.erpsystem.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.erpsystem.repository.S3Repository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStorageService {

    @Autowired
    S3Repository fileStorageRepository;

    @Value("${pdf.thumbnail.width}") int THUMBNAIL_WIDTH;

    public Pair<String, List<String>> uploadDrawing(MultipartFile file, String filename) throws IOException {
        String pdfKey = String.format("drawings/%s", filename + ".pdf");
        fileStorageRepository.uploadFile(
                file.getInputStream().readAllBytes(),
                pdfKey
        );

        List<BufferedImage> thumbs = createThumbnails(file.getInputStream());

        List<String> thumbKeys = new ArrayList<>();
        for (int i = 0; i < thumbs.size(); i++) {
            BufferedImage thumb = thumbs.get(i);
            String thumbKey = String.format(
                    "drawings/thumbs/%s_page_%d.png",
                    filename,
                    i
            );
            thumbKeys.add(thumbKey);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(thumb, "png", os);
            byte[] imgBytes = os.toByteArray();

            fileStorageRepository.uploadFile(imgBytes, thumbKey);
        }

        return Pair.of(pdfKey, thumbKeys);
    }

    private List<BufferedImage> createThumbnails(InputStream is) throws IOException {
        try (PDDocument doc = PDDocument.load(is)) {
            List<BufferedImage> thumbs = new ArrayList<>(doc.getNumberOfPages());
            PDFRenderer renderer = new PDFRenderer(doc);

            for (int i = 0; i < doc.getNumberOfPages(); ++i) {
                BufferedImage bim = renderer.renderImage(i);
                double scale = (double) THUMBNAIL_WIDTH / bim.getWidth();
                bim = resizeImage(bim, THUMBNAIL_WIDTH, (int)(bim.getHeight() * scale));
                thumbs.add(bim);
            }
            return thumbs;
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    public byte[] downloadDrawing(String key) throws IOException {
        return fileStorageRepository.downloadFile(key);
    }

    public void deleteDrawing(String pdfKey, List<String> thumbKeys) throws FileNotFoundException {
        fileStorageRepository.deleteFile(pdfKey);
        for (String key : thumbKeys) {
            fileStorageRepository.deleteFile(key);
        }
    }

}
