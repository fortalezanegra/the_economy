package br.com.economy.shared.exception;

public class RegraDeNegocioException extends RuntimeException{

    public RegraDeNegocioException(String mensagem){
        super(mensagem);
    }
}
