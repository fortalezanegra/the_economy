package br.com.economy.personagem.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonagemRequest {

    private Long id;

    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
}
