package dev.Java10x.CadastroDeNinjas.Ninja;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// entity transforma uma classe em entidade do BD
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;

    @Column(name = "imagem_url")
    private String imagemUrl;
    private int idade;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne um ninja possui uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreign key
    private MissoesModel missoes;
}

