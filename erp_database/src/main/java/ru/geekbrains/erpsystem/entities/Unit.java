package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "units")
@Data
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "art")
    private String art;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "constructor_id")
    private User constructor;

    @Column(name = "is_asm")
    private boolean isAsm;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @Column(name = "material_amount")
    private Float materialAmount;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technology technology;

    /*todo:
    *  Добавить поля для связи с файлами чертежей и миниатюр (thumbnails) листов.
    * Чертежи будут храниться на Amazon S3.
    */

}
