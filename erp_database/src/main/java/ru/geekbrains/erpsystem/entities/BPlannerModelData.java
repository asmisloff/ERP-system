package ru.geekbrains.erpsystem.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bplanner_model_data")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BPlannerModelData {

    public BPlannerModelData(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BPlannerModelData that = (BPlannerModelData) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1677544227;
    }
}
