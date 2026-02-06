package dev.Java10x.CadastroDeNinjas.Missoes;

import dev.Java10x.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Listar
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoesModel = missoesRepository.findAll();
        return missoesModel.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoId(Long id){
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        return missaoId.map(missoesMapper::map).orElse(null);
    }

    // Criar
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    // Atualizar
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        if (missaoExiste.isPresent()){
            MissoesModel missao = missoesMapper.map(missoesDTO);
            missao.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missao);
            return missoesMapper.map(missaoSalva);
        } else {
            return null;
        }
    }

    // Deletar
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
