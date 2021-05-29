package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "drawing_thumbnails")
@Data
public class DrawingThumbnail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "drawing_id")
    Drawing drawing;

}
