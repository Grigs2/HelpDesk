package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serial;
import java.io.Serializable;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String senha,
        String cargo,
        String telefone,
        PerfilDTO perfilDTO
) implements Serializable {

    @Serial
    public static final long serialVersionUID = -1231231232L;

    public static UsuarioDTO valueOf(Usuario usuario) {
        if (usuario != null) {
            return new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getCargo(),
                    usuario.getTelefone(),
                    PerfilDTO.valueOf(usuario.getPerfil()));
        } else {
            return null;
        }
    }
    public static Usuario toUsuario(UsuarioDTO dto){
        if(dto!=null && dto.perfilDTO != null){
            Usuario usuario = new Usuario();
            usuario.setId(dto.id);
            usuario.setNome(dto.nome);
            usuario.setEmail(dto.email);
            usuario.setSenha(dto.senha);
            usuario.setCargo(dto.cargo);
            usuario.setTelefone(dto.telefone);
            usuario.setPerfil(PerfilDTO.toPerfil(dto.perfilDTO));
            return usuario;
        }
        else return null;
    }
}
