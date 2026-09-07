package br.com.economy.shared.exception;

public class PersonagemNaoEncontradoException extends RuntimeException{

    public PersonagemNaoEncontradoException(Long id){
        super("Personagem não encontrado com o id: " + id);
    }
}
