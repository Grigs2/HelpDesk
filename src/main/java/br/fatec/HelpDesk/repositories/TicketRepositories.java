package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepositories extends JpaRepository<Ticket, Long> {
}
