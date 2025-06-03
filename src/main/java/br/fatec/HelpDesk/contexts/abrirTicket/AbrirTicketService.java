package br.fatec.HelpDesk.contexts.abrirTicket;

import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Status;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.enums.TipoStatus;
import br.fatec.HelpDesk.repositories.StatusRepositories;
import br.fatec.HelpDesk.repositories.TicketRepositories;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.TicketService;
import br.fatec.HelpDesk.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AbrirTicketService {

    @Autowired
    TicketService ticketService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private StatusRepositories statusRepositories;

    @Transactional
    public Ticket abrirTicket(AbrirTicketDTO dto){
        Usuario solicitante = usuarioService.findById(dto.id_usuario());
        Equipe equipe = equipeService.findById(dto.id_equipe());
        if(solicitante!=null&&equipe!=null){
            Status status= new Status(TipoStatus.AGUARDANDO_ATENDIMENTO);
            status = statusRepositories.save(status);

            Ticket ticket = new Ticket();
            ticket.setSolicitante(solicitante);
            ticket.setEquipe(equipe);
            ticket.setTitulo(dto.titulo());
            ticket.setDescricao(dto.descricao());
            ticket.setDataAbertura(LocalDateTime.now());

            ticket.setUltimoStatus(status);

            return ticketService.save(ticket);
        }return null;
    }
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }
    public List<Ticket> findByEquipe(Long idEquipe){
       List<Ticket> todosTickets = ticketService.findAll();
       List<Ticket> ticketsDaEquipe = new ArrayList<>();
       todosTickets.forEach( ticket ->{
               if(idEquipe.equals(ticket.getEquipe().getId())) ticketsDaEquipe.add(ticket);});
       return ticketsDaEquipe;
    }

}
