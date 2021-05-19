package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.erpsystem.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
