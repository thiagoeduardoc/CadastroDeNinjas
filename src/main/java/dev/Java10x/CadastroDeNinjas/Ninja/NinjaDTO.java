package dev.Java10x.CadastroDeNinjas.Ninja;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private String imagemUrl;
    private int idade;
    private String rank;
    private MissoesModel missoes;
}
