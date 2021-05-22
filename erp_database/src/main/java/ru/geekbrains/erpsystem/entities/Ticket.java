package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "constructor_id")
    private User constructor;

    @ManyToOne
    @JoinColumn(name = "technologist_id")
    private User technologist;

    @ManyToOne
    @JoinColumn(name = "planner_id")
    private User planner;

    @ManyToOne
    @JoinColumn(name = "time_study_engineer_id")
    private User timeStudyEngineer;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER)
    List<UnitEntry> unitEntryList;

}
