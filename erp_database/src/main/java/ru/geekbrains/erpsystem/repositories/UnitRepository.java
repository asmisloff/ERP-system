package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
