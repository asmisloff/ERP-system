package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.BPlannerModelData;

@Repository
public interface BPlannerModelDataRepository extends JpaRepository<BPlannerModelData, Long> {
}
