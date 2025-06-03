package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.repositories.TicketRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

    @Autowired
    TicketRepositories ticketRepositories;

    public List<Ticket> findAll(){
        return ticketRepositories.findAll();
    }
    public Ticket save(Ticket ticket){
        return ticketRepositories.save(ticket);
    }
    public Ticket findById(Long id){
        return ticketRepositories.findById(id).orElse(null);
    }

}
