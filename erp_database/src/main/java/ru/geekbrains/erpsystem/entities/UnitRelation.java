package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "unit_relations")
@Data
public class UnitRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asm_id", nullable = false)
    private Unit asm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "part_id", nullable = false)
    private Unit part;

    @Column(name = "qty")
    Integer qty;

}
