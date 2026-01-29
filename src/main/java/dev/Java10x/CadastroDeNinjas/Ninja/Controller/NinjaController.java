package dev.Java10x.CadastroDeNinjas.Ninja.Controller;

import dev.Java10x.CadastroDeNinjas.Ninja.NinjaModel;
import dev.Java10x.CadastroDeNinjas.Ninja.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotations
@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas READ
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id (read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasId(@PathVariable Long id){
        return ninjaService.listarNinjasId(id);
    }

    // Alterar dados do ninja UPDATE
    @PutMapping("/alterarid")
    public String alterarNinjaPorId(){
        return "alterar ninja por id";
    }

    // Deletar ninja DELETE
    @DeleteMapping("/deletarid")
    public String deletarNinjaPorId(){
        return "Ninja deletado por id";
    }
}
