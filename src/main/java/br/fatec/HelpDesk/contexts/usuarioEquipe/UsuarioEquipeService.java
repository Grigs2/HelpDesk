package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.entities.UsuarioEquipe;
import br.fatec.HelpDesk.repositories.UsuarioEquipeRepositories;
import br.fatec.HelpDesk.repositories.UsuarioRepositories;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioEquipeService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EquipeService equipeService;

    @Autowired
    UsuarioEquipeRepositories usuarioEquipeRepositories;
    @Autowired
    private UsuarioRepositories usuarioRepositories;

    public Usuario findByEmail(String email){
        return usuarioService.findByEmail(email);//orElse(null);
    }
//    public Usuario findById(Long id){
//        return usuarioService.findById(id);//.orElse(null);
//    }
    public List<Usuario> findAll(){
         return usuarioService.findAll();
    }

    //Apesar de estar usando o usuarioRepositories eu posso adicionar uma nova função especifica da situação
    //necessária do context
    public Usuario addEquipes(String email, List<EquipeDTO> dtos){
        if(email==null)return null;
        Usuario usuario = usuarioService.findByEmail(email);
        if(usuario==null||dtos==null)return null;
        //transforma a lista de equipeDTO em lista de ids das equipes
        List<Long> idsEquipe = dtos.stream().map(EquipeDTO::id).filter(Objects::nonNull).toList();
        //cria uma lista de Equipes apartir dos ids separados
        List<Equipe> equipesNovas = equipeService.findAllById(idsEquipe);
        List<UsuarioEquipe> usuarioEquipesAtuais = usuarioEquipeRepositories.findByUsuario(usuario);

        usuarioEquipesAtuais.stream()
                .filter(usuarioEquipe->equipesNovas.stream()
                    .noneMatch(equipe->equipe.getId()
                        .equals(usuarioEquipe.getEquipe().getId())))
                .forEach(usuarioEquipe-> {usuarioEquipe.setAtivo(false);
                        usuarioEquipeRepositories.save(usuarioEquipe);
                        }
                );

        for(Equipe equipe:equipesNovas){
            boolean jaExiste = usuarioEquipesAtuais.stream()
                                .anyMatch(usuarioEquipe->usuarioEquipe.getEquipe().getId()
                                    .equals(equipe.getId()));
            if(!jaExiste){
                UsuarioEquipe nova = new UsuarioEquipe();
                nova.setEquipe(equipe);
                nova.setUsuario(usuario);
                nova.setAtivo(true);
                usuarioEquipeRepositories.save(nova);
            } else{
                usuarioEquipesAtuais.stream()
                        .filter(usuarioEquipe->usuarioEquipe.getEquipe().getId()
                                .equals(equipe.getId()))
                        .forEach(usuarioEquipe->{usuarioEquipe.setAtivo(true);
                        usuarioEquipeRepositories.save(usuarioEquipe);});
            }
        }

        return usuario;
    }
}
