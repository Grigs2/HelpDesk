package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.entities.UsuarioEquipe;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public record UsuarioEquipeDTO(
        String nome,
        String email,
        String perfil,
        List<String> equipes
) implements java.io.Serializable{

    @Serial
    public static final long serialVersionUID = 123123123123123123L;

    public static UsuarioEquipeDTO valueOf(Usuario usuario){
        if(usuario!=null){
            List<String> equipes = new ArrayList<>();
            if(usuario.getEquipe()!=null)usuario.getEquipe().forEach(equipe -> equipes.add(equipe.getEquipe()));
            return new UsuarioEquipeDTO(
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getPerfil().getPerfil(),
                    equipes
                    );
        }return null;
    }

}
