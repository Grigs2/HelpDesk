package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.repositories.CategoriaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepositories categoriaRepositories;

    public Categoria cadastrar(String nomeCategoria){
        return categoriaRepositories.save(new Categoria(nomeCategoria));
    }



}
