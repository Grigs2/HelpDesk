package br.fatec.HelpDesk.contexts.Autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Autenticacao")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @GetMapping("/{email}/{senha}")
    public @ResponseBody ResponseEntity<AutenticacaoDTO> autenticar(@PathVariable String email,
                                                                    @PathVariable String senha) {
//      Usuario usuario = autenticacaoService.autenticar(email, senha);
        AutenticacaoDTO autenticacaoDTO = AutenticacaoDTO.valueOf(autenticacaoService.autenticar(email, senha));
        if (autenticacaoDTO != null) {
            return ResponseEntity.ok().body(autenticacaoDTO);
        }
        return ResponseEntity.badRequest().build();
    }
}
