package br.fatec.HelpDesk.services;


import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.repositories.EquipeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    EquipeRepositories equipeRepositories;

    public Equipe cadastrar(String nomeEquipe){
        return equipeRepositories.save(new Equipe(nomeEquipe));
    }
    public List<Equipe> findAll(){
        return equipeRepositories.findAll();
    }
    public Equipe findById(Long id){
        return equipeRepositories.findById(id).orElse(null);
    }
    public List<Equipe> findAllById(List<Long> ids){
        return equipeRepositories.findAllById(ids);
    }
}
