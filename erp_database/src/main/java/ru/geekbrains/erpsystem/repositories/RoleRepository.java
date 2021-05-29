package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
