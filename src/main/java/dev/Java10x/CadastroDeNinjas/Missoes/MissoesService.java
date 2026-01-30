package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Criar
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    // Deletar
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
