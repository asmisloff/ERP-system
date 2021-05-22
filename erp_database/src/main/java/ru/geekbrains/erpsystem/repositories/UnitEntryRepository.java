package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.UnitEntry;

public interface UnitEntryRepository extends JpaRepository<UnitEntry, Long> {
}
