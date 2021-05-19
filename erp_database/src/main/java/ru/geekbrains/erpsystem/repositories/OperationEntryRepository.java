package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.OperationEntry;

public interface OperationEntryRepository extends JpaRepository<OperationEntry, Long> {
}
