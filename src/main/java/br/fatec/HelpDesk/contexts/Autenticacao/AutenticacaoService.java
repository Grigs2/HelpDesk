package br.fatec.HelpDesk.contexts.Autenticacao;

import br.fatec.HelpDesk.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private AutenticacaoRepositiries autenticacaoRepositiries;

    public Usuario autenticar(String email, String senha){
        return autenticacaoRepositiries.findByEmailAndSenha(email, senha).orElse(null) ;
    }

}
