package br.fatec.HelpDesk.contexts.abrirTicket;

import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

public record AbrirTicketDTO(
        @NotNull(message = "usuario não pode ser nulo")
        Long id_usuario,
        @NotBlank(message = "titulo não pode ser nulo")
        String titulo,
        @NotBlank(message = "descricao não pode ser nulo")
        String descricao,
        @NotNull(message = "equipe não pode ser nulo")
        Long id_equipe
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1123232312312312L;

    public static AbrirTicketDTO valueOf(Ticket ticket) {
        if (ticket != null) {
            return new AbrirTicketDTO(
                    ticket.getId(),
                    ticket.getTitulo(),
                    ticket.getDescricao(),
                    ticket.getEquipe().getId());
        } else {
            return null;
        }
    }



}
