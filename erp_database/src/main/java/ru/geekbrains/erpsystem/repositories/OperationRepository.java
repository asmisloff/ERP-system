package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.erpsystem.entities.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long> {
}
