package br.com.economy.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Map<String, Object>> handlerRegraDeNegocio(RegraDeNegocioException ex) {

        Map<String, Object> corpo = Map.of(
                "timestamp", Instant.now().toString(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "erro", "Regra de negócio violada",
                "mensagem", ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(corpo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerValidacao(MethodArgumentNotValidException ex) {

        // Mapa que vai guardar: nome do campo -> mensagem de erro
        Map<String, String> erros = new LinkedHashMap<>();

        // Percorre todos os campos que falharam na validação
        for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
            erros.put(erro.getField(), erro.getDefaultMessage());
        }

        Map<String, Object> corpo = Map.of(
                "timestamp", Instant.now().toString(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "erro", "Erro de validação",
                "campos", erros
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(corpo);
    }

    @ExceptionHandler(PersonagemNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handlePersonagemNaoEncontrado(PersonagemNaoEncontradoException ex) {
        Map<String, Object> erro = new LinkedHashMap<>();
        erro.put("timestamp", Instant.now().toString());
        erro.put("status", HttpStatus.NOT_FOUND.value());
        erro.put("erro", "Recurso não encontrado");
        erro.put("mensagem", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
