package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
