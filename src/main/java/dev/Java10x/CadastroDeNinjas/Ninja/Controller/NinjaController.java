package dev.Java10x.CadastroDeNinjas.Ninja.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Anotations
@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }
}
