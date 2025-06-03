package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/UsuarioEquipe")
public class UsuarioEquipeController {

    @Autowired
    UsuarioEquipeService usuarioEquipeService;


    @PostMapping("/Add/{email}")
    public @ResponseBody ResponseEntity<UsuarioEquipeDTO> addEquipes(@PathVariable @Valid String email,
                                                                     @RequestBody @Valid List<EquipeDTO> dto){
        Usuario usuario = usuarioEquipeService.addEquipes(email, dto);
        return ResponseEntity.ok().body(UsuarioEquipeDTO.valueOf(usuario));
    }

    @GetMapping("/Find/{email}")
    public @ResponseBody ResponseEntity<UsuarioEquipeDTO> findByEmail(@PathVariable String email){
        Usuario usuario = usuarioEquipeService.findByEmail(email);
        return ResponseEntity.ok().body(UsuarioEquipeDTO.valueOf(usuario));
    }



//    @GetMapping("/all")
//    public @ResponseBody ResponseEntity<List<UsuarioEquipeDTO>> findAll(){
//        List<Usuario> usuarios = usuarioEquipeService
//    }




}
