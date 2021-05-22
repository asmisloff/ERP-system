package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.erpsystem.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
