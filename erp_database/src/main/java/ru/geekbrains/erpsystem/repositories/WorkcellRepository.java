package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.erpsystem.entities.Workcell;

public interface WorkcellRepository extends CrudRepository<Workcell, Long> {
}
