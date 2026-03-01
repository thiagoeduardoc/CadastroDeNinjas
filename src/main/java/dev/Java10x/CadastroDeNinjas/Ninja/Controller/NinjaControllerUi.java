package dev.Java10x.CadastroDeNinjas.Ninja.Controller;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.Java10x.CadastroDeNinjas.Missoes.MissoesService;
import dev.Java10x.CadastroDeNinjas.Ninja.NinjaDTO;
import dev.Java10x.CadastroDeNinjas.Ninja.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService ninjaService;
    private final MissoesService missoesService;

    public NinjaControllerUi(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarNinjasId(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
        if (ninjaService.listarNinjasId(id) != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());

        List<MissoesDTO> todasMissoes = missoesService.listarMissoes();
        model.addAttribute("missoes", todasMissoes);

        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes){
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
        // Buscamos todas as missões cadastradas para o dropdown
        List<MissoesDTO> todasMissoes = missoesService.listarMissoes();

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            model.addAttribute("missoes", todasMissoes); // Adiciona a lista ao model
            return "alterarninja";
        }
        return "redirect:/ninjas/ui/listar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.atualizarNinja(id, ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja atualizado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }




}
