package br.fatec.HelpDesk.controllers;

import br.fatec.HelpDesk.dtos.CategoriaDTO;
import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/Salvar/{nomeCategoria}")
    public @ResponseBody ResponseEntity<CategoriaDTO> salvarCategoria(@PathVariable String nomeCategoria){
        Categoria categoria = categoriaService.cadastrar(nomeCategoria);
        return ResponseEntity.ok().body(CategoriaDTO.valueOf(categoria));
    }

}
