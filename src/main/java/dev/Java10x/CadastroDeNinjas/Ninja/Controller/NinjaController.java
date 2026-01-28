package dev.Java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.web.bind.annotation.*;

// Anotations
@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas READ
    @GetMapping("/todos")
    public String mostrarTodosNinjas(){
        return "Ninjas mostrados";
    }

    // Mostrar ninja por id (read)
    @GetMapping("/todosid")
    public String mostrarNinjasPorID(){
        return "Mostrar ninja por id";
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
