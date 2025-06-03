package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.Mappers.MapperGeral;
import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;


    @PostMapping("/Salvar/{nomeEquipe}")
    public @ResponseBody ResponseEntity<EquipeDTO> salvarEquipe(@PathVariable String nomeEquipe){
        Equipe Equipe= equipeService.cadastrar(nomeEquipe);
        return ResponseEntity.ok().body(EquipeDTO.valueOf(Equipe));
    }
    @GetMapping("/All")
    public @ResponseBody ResponseEntity<List<EquipeDTO>> allEquipes(){
        return ResponseEntity.ok().body(MapperGeral.listToEquipeDTOList(equipeService.findAll()));
    }
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<EquipeDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(EquipeDTO.valueOf(equipeService.findById(id)));
    }
}
