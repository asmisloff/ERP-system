package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.erpsystem.entities.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {
}
