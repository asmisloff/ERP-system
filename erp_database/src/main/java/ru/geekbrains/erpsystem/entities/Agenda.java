package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "agenda")
@Data
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "workcell_id")
    private Workcell workcell;

    @ManyToOne(optional = false)
    @JoinColumn(name = "technology_id")
    private Technology technology;

    @Column(name = "start_date_time")
    private Date startDateTime;

}
