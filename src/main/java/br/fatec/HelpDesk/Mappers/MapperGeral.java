package br.fatec.HelpDesk.Mappers;

import br.fatec.HelpDesk.contexts.abrirTicket.AbrirTicketDTO;
import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapperGeral implements Serializable {

    @Serial
    public static final long serialVersionUID = -1231231232L;

    public static List<PerfilDTO> perfilListToPerfilDTOList(List<Perfil> listaPerfil) {
        if(listaPerfil!=null && !listaPerfil.isEmpty()){
         List<PerfilDTO> dtos = new ArrayList<>();
//         Para cada Perfil na listaPerfil ele converterá um DTO na lista dtos
         listaPerfil.forEach(perfil -> dtos.add(PerfilDTO.valueOf(perfil)));
         return dtos;
        }else {
            return null;
        }
    }

    public static List<UsuarioDTO> usuarioListToUsuarioDTOList(List<Usuario> listaUsuario) {
        if(listaUsuario!=null && !listaUsuario.isEmpty()){
            List<UsuarioDTO> dtos = new ArrayList<>();
            listaUsuario.forEach(usuario -> dtos.add(UsuarioDTO.valueOf(usuario)));
            return dtos;
        }else {
            return null;
        }
    }
    public static List<EquipeDTO> listToEquipeDTOList(List<Equipe> listaEquipe) {
        if(listaEquipe!=null && !listaEquipe.isEmpty()){
            List<EquipeDTO> dtos = new ArrayList<>();
            listaEquipe.forEach(equipe -> dtos.add(EquipeDTO.valueOf(equipe)));
            return dtos;
        }else {
            return null;
        }
    }

    public static List<AbrirTicketDTO> listToAbrirTicketDTOList(List<Ticket> listaTicket) {
        if(listaTicket!=null && !listaTicket.isEmpty()){
            List<AbrirTicketDTO> dtos = new ArrayList<>();
            listaTicket.forEach(ticket -> dtos.add(AbrirTicketDTO.valueOf(ticket)));
            return dtos;
        }else {
            return null;
        }
    }
    public static List<Ticket> retirarConcluidos(List<Ticket> tickets){
        if(tickets==null || tickets.isEmpty()) return null;
        List<Ticket> naoConcluidos = new ArrayList<>();
        tickets.forEach(ticket -> {
            if (!"CONCLUIDO".equals(ticket.getUltimoStatus().getStatus())) {
                naoConcluidos.add(ticket);}});
        return naoConcluidos;
    }


}
