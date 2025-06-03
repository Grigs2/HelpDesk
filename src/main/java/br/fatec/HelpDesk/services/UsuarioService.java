package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositories usuarioRepositories;


    public Usuario findById(Long id){
        return usuarioRepositories.findById(id).orElse(null);
    }

    public Usuario cadastrar(Usuario usuario){ //Ao invez de uma string, estou recebdo uma classe inteira
        if(usuario!=null)return usuarioRepositories.save(usuario);
        else return null;
    }
    public List<Usuario> findAll(){
        return usuarioRepositories.findAll();
    }

    public Usuario mudarSenha(String email, String senha, String novaSenha){
        Usuario usuario = findByEmail(email);
        if (usuario != null) {
            if(usuario.getSenha().equals(senha)){
                usuario.setSenha(novaSenha);
                return usuarioRepositories.save(usuario); //save serve para alterar usuarios com o mesmo id
            }
        }
        return null;
    }

    public Usuario findByEmail(String email){
        if(email!=null && !email.isEmpty()){
            return usuarioRepositories.findByEmail(email).orElse(null);
        }
        return null;
    }
    public void deleteUser(Long id){
        usuarioRepositories.findById(id)
                .ifPresent(
                        usuario -> usuarioRepositories.delete(usuario)
                );
//      isso significa o seguinte:
//      Usuario usuario = usuarioRepositories.findById(id).orElse(null);
//      if(usuario!=null)usuarioRepositories.delete(usuario);
    }
}
