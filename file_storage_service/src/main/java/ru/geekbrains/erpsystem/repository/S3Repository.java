package ru.geekbrains.erpsystem.repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.InvalidMimeTypeException;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Repository
public class S3Repository {

    private final Logger logger = LoggerFactory.getLogger(S3Repository.class);
    private final String ACCESS_KEY = System.getenv("s3_access_key");
    private final String SECRET_KEY = System.getenv("s3_secret_key");
    private final String BUCKET_NAME = System.getenv("s3_bucket_name");
    private AmazonS3 s3client;

    @PostConstruct
    public void init() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

        s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.EU_CENTRAL_1)
                .build();
    }

    public void uploadFile(byte[] data, String path) throws IOException {
        ObjectMetadata fileMetadata = new ObjectMetadata();

        String contentType;
        if (path.endsWith(".pdf")) {
            contentType = "application/pdf";
        } else if (path.endsWith(".png")) {
            contentType = "image/png";
        } else {
            throw new InvalidMimeTypeException(path, " -- Illegal file type");
        }
        fileMetadata.setContentType(contentType);
        fileMetadata.setContentLength(data.length);

        PutObjectRequest putObjectRequest = new PutObjectRequest(
                BUCKET_NAME,
                path,
                new ByteArrayInputStream(data),
                fileMetadata
        );
        s3client.putObject(putObjectRequest);

        logger.info(String.format("Uploaded -- %s (%d)", path, data.length));
    }

    public byte[] downloadFile(String key) throws IOException {
        S3Object file = s3client.getObject(BUCKET_NAME, key);
        return file.getObjectContent().readAllBytes();
    }

    public void deleteFile(String key) {
        s3client.deleteObject(BUCKET_NAME, key);
    }

}

