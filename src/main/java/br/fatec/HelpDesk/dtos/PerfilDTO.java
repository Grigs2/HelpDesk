package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Perfil;

import java.io.Serial;
import java.io.Serializable;

public record PerfilDTO(Long id, String nomePerfil) implements Serializable {

    @Serial
    public static final long serialVersionUID = -128936712890363L;

    public static PerfilDTO valueOf(Perfil perfil){
        if (perfil!=null){
            return new PerfilDTO(perfil.getId(), perfil.getPerfil());
        }
        return null;
    }

    public static Perfil toPerfil(PerfilDTO dto){
        if (dto!=null){
            return new Perfil(dto.id, dto.nomePerfil);
        }
        return null;
    }


}
