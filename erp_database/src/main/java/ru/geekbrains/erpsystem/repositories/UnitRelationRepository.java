package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.UnitRelation;

public interface UnitRelationRepository extends JpaRepository<UnitRelation, Long> {
}
