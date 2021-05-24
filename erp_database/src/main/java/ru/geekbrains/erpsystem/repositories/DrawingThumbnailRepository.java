package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.DrawingThumbnail;

import java.util.List;

public interface DrawingThumbnailRepository extends JpaRepository<DrawingThumbnail, Long> {
    List<DrawingThumbnail> findAllByDrawingId(Long id);
}
