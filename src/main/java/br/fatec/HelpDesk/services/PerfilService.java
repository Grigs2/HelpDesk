package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.repositories.PerfilRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    PerfilRepositories perfilRepositories;


    public Perfil cadastrar(String nomePerfil){ //Salva e retorna o perfil salvo
        return perfilRepositories.save(new Perfil(nomePerfil));
    }

    public List<Perfil> findAll(){
        return perfilRepositories.findAll();
    }

    public Perfil findById(Long id){
        return perfilRepositories.findById(id).orElse(null);
    }
}
