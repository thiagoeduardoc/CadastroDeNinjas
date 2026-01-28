package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Get -- mandar uma requisição para mostrar missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas";
    }

    // post -- mandar uma requisição para criar missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    // Put -- mandar uma requisição para alterar missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return  "Missao alterada";
    }

    // Delete -- mandar uma requisição para deletar missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada";
    }
}
