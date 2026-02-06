package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Get -- mandar uma requisição para mostrar missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>>  listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoId(@PathVariable Long id){
        if (missoesService.listarMissaoId(id) != null) {
            MissoesDTO missoesDTO = missoesService.listarMissaoId(id);
            return ResponseEntity.ok(missoesDTO);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada");
        }
    }

    // post -- mandar uma requisição para criar missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    // Put -- mandar uma requisição para alterar missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao){
        if (missoesService.listarMissaoId(id) != null) {
            MissoesDTO missoesDTO = missoesService.atualizarMissao(id, missao);
            return ResponseEntity.ok(missoesDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada");
        }
    }

    // Delete -- mandar uma requisição para deletar missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missoesService.listarMissaoId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão Deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao não encontrada");
        }
    }
}
