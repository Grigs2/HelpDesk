package br.fatec.HelpDesk.contexts.abrirTicket;

import br.fatec.HelpDesk.Mappers.MapperGeral;
import br.fatec.HelpDesk.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import jakarta.validation.*;
import java.util.List;

@RestController
@RequestMapping("/AbrirTicket")
public class AbrirTicketController {

    @Autowired
    private AbrirTicketService abrirTicketService;

    @PostMapping("/Salvar")
    public @ResponseBody ResponseEntity<Object> abrirTicket(@RequestBody @Valid AbrirTicketDTO dto){

        if (dto!=null){
            if(abrirTicketService.abrirTicket(dto)!=null)
                return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @GetMapping("/All")
    public @ResponseBody ResponseEntity<List<AbrirTicketDTO>> mostrarChamados(){
        return ResponseEntity.ok().body(MapperGeral.listToAbrirTicketDTOList(abrirTicketService.findAll()));
    }
    @GetMapping("/All/NotConcluded")
    public @ResponseBody ResponseEntity<List<AbrirTicketDTO>> mostrarChamadosNaoConluidos(){
        List<Ticket> todos = abrirTicketService.findAll();
        return ResponseEntity.ok().body(MapperGeral.listToAbrirTicketDTOList(MapperGeral.retirarConcluidos(todos)));
    }
    @GetMapping("/{equipe}")
    public @ResponseBody ResponseEntity<List<AbrirTicketDTO>> mostrarChamadosPorEquipe(@PathVariable Long equipe){
        return ResponseEntity.ok().body(MapperGeral.listToAbrirTicketDTOList(abrirTicketService.findByEquipe(equipe)));
    }
}
