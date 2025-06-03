package br.fatec.HelpDesk.controllers;

import br.fatec.HelpDesk.Mappers.MapperGeral;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.repositories.UsuarioRepositories;
import br.fatec.HelpDesk.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

//    create
    @PostMapping("/Salvar")
    public @ResponseBody ResponseEntity<UsuarioDTO> SalvarUsuario(@RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.cadastrar(UsuarioDTO.toUsuario(dto));
        return ok().body(UsuarioDTO.valueOf(usuario));
    }
//      read
    @GetMapping("/All")
    public @ResponseBody ResponseEntity<List<UsuarioDTO>> ListarTodosUsuarios(){
        List<Usuario> ListaUsuario = usuarioService.findAll();
        return ResponseEntity.ok().body(MapperGeral.usuarioListToUsuarioDTOList(ListaUsuario));
    }

    @GetMapping("/{email}")
    public @ResponseBody ResponseEntity<UsuarioDTO> BuscarPorEmail(@PathVariable String email){
        Usuario usuario = usuarioService.findByEmail(email);
        return ResponseEntity.ok().body(UsuarioDTO.valueOf(usuario));
    }
//      Update
    @PutMapping("/MudarSenha/{email}/{senhaAtual}/{novaSenha}")
    public @ResponseBody ResponseEntity<UsuarioDTO> mudarSenha(@PathVariable String email,
                                                               @PathVariable String senhaAtual,
                                                               @PathVariable String novaSenha){
        Usuario usuario = usuarioService.mudarSenha(email, senhaAtual, novaSenha);
        return ResponseEntity.ok().body(UsuarioDTO.valueOf(usuario));
    }

//    Delete
    @DeleteMapping("/Delete/{id}")
    public @ResponseBody ResponseEntity<List<UsuarioDTO>> DeleteUser(@PathVariable Long id){
        usuarioService.deleteUser(id);
        return ResponseEntity.ok().body(MapperGeral.usuarioListToUsuarioDTOList(usuarioService.findAll()));
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(UsuarioDTO.valueOf(usuarioService.findById(id)));
    }
}
