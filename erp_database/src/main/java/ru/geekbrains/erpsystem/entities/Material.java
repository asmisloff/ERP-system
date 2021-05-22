package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "materials")
@Data
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "art", nullable = false)
    private String art;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

}
