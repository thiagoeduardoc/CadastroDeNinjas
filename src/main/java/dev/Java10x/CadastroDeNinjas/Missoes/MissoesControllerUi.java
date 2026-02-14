package dev.Java10x.CadastroDeNinjas.Missoes;

import dev.Java10x.CadastroDeNinjas.Ninja.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {
    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarmissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarMissaoId(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarMissaoId(id);
        if (missoesService.listarMissaoId(id) != null){
            model.addAttribute("missao", missao);
            return "detalhesmissao";
        } else {
            model.addAttribute("mensagem", "Missão não encontrada");
            return "listarmissoes";
        }
    }

    @GetMapping("/adicionar")
    public String formularioAdicionarMissao(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarmissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes){
        missoesService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missao cadastrada");
        return "redirect:/missoes/ui/listar";
    }
}
