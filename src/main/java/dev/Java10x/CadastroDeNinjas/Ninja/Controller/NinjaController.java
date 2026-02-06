package dev.Java10x.CadastroDeNinjas.Ninja.Controller;

import dev.Java10x.CadastroDeNinjas.Ninja.NinjaDTO;
import dev.Java10x.CadastroDeNinjas.Ninja.NinjaModel;
import dev.Java10x.CadastroDeNinjas.Ninja.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotations
@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + "Id: " + ninjaDTO.getId());
    }

    // Mostrar todos os ninjas READ
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por id (read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasId(@PathVariable Long id){
        if (ninjaService.listarNinjasId(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.listarNinjasId(id);
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }

    // Alterar dados do ninja UPDATE
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        if (ninjaService.listarNinjasId(id) != null){
            NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }

    // Deletar ninja DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjasId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja Deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }
}
