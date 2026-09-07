package br.com.economy.personagem.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PersonagemResponse {
    private String nome;
    private int saude;
    private BigDecimal dinheiro;
}
