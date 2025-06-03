package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record EquipeDTO(Long id, String nomeEquipe) implements Serializable {

    @Serial
    public static final long serialVersionUID = -128936712890L;

    public static EquipeDTO valueOf(Equipe equipe) {
        if (equipe != null) return new EquipeDTO(equipe.getId(), equipe.getEquipe());
        else return null;
    }
    public static Equipe toEquipe(EquipeDTO dto) {
        if (dto != null) return new Equipe(dto.id, dto.nomeEquipe);
        else return null;
    }

}
