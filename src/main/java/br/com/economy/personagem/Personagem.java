package br.com.economy.personagem;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // importante: usa AUTO_INCREMENT do MySQL
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "saude")
    private int saude;

    @Column(name = "dinheiro", precision = 19, scale = 2)
    private BigDecimal dinheiro;

    protected Personagem(){}

    private Personagem(String nome, int saude, BigDecimal dinheiro){
        this.nome = nome;
        this.saude = saude;
        this.dinheiro = dinheiro;
    }

    public static Personagem novo(String nome){
        return new Personagem(nome, 100, BigDecimal.ZERO);
    }

}
