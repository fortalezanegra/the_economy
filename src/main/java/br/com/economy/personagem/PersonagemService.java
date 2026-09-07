package br.com.economy.personagem;

import br.com.economy.shared.exception.PersonagemNaoEncontradoException;
import br.com.economy.shared.exception.RegraDeNegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    private final PersonagemRepository repository;

    public PersonagemService(PersonagemRepository repository){
        this.repository = repository;
    }

    //Get by ID
    public Personagem buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow( () -> new PersonagemNaoEncontradoException(id));
    }

    //Create
    public Personagem criar(String nome){

        if(nome == null || nome.trim().isEmpty()){
            throw new RegraDeNegocioException("O nome não pode estar vazio");
        }
        Personagem novoPersonagem = Personagem.novo(nome);
        repository.save(novoPersonagem);

        return novoPersonagem;
    }

}
