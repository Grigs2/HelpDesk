package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.Mappers.MapperGeral;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @PostMapping("/Salvar/{nomePerfil}") //caminho que a aplicacao chamará
    //@responsebody = Retorna uma resposta de corpo de pagina(site)
    //@responseentity = Retorna um codigo correspondente ao status da operação (falha, sucesso, etc...)
    //@pathvariable = declara que a váriavel nomePerfil virá dentro do path e será utilizada na função
    public @ResponseBody ResponseEntity<PerfilDTO> salvarPerfil(@PathVariable String nomePerfil){
        Perfil Perfil = perfilService.cadastrar(nomePerfil);
        return ResponseEntity.ok().body(PerfilDTO.valueOf(Perfil));
    }

    @GetMapping("/All")
    public @ResponseBody ResponseEntity<List<PerfilDTO>> listarPerfis(){
        List<Perfil> listaTodosPerfils = perfilService.findAll();
//        Consumindo a função de transformar uma lista de Entidades em uma lista de DTOs para o front
        return ResponseEntity.ok().body(MapperGeral.perfilListToPerfilDTOList(listaTodosPerfils));
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<PerfilDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(PerfilDTO.valueOf(perfilService.findById(id)));
    }

}
