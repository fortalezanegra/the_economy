package br.com.economy.personagem;

import br.com.economy.personagem.dto.PersonagemRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/economy/personagens")
@CrossOrigin(origins = "*")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service){
        this.service = service;
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Personagem> getById(@PathVariable Long id){
        Personagem personagem = service.buscarPorId(id);
        return ResponseEntity.ok(personagem);
    }

    //Criar novo Personagem
    @PostMapping()
    public ResponseEntity<Personagem> create(@RequestBody @Valid PersonagemRequest dto){

            Personagem personagem = service.criar(dto.getNome());

            URI location = ServletUriComponentsBuilder // Classe utilitaria do Spring MVC usada para construir URIs/URLs.
                    .fromCurrentRequest() // Captura a URL da requisição ex: POST http://localhost:8080/api/economy/personagens
                    .path("/{id}") // adiciona /{id} no final da URL
                    .buildAndExpand(personagem.getId()) // Substitui /{id} pelo valor real do id gerado no database.
                    .toUri(); // Converte o resultado atual que é um objeto UriComponents para um objeto URI Java que é
                    // exigido pelo método ResponseEntity.created(...).

            return ResponseEntity.created(location).body(personagem);

    }
}
