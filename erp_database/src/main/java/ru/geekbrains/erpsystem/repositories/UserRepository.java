package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
