package br.fatec.HelpDesk.contexts.Autenticacao;

import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serial;

public record AutenticacaoDTO(
    String nome,
    String cargo,
    String email,
    String perfil
                            ) implements java.io.Serializable{

    @Serial
    public static final long serialVersionUID = 123123123123123123L;

    public static AutenticacaoDTO valueOf(Usuario usuario){
        if(usuario!=null){
            return new AutenticacaoDTO(
                    usuario.getNome(),
                    usuario.getCargo(),
                    usuario.getEmail(),
                    usuario.getPerfil().getPerfil());
        }
        return null;
    }



}
