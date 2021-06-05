package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.erpsystem.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
