package br.com.otavio.projetopais.controller;

import br.com.otavio.projetopais.model.Pais;
import br.com.otavio.projetopais.services.Impl.PaisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisServiceImpl paisService;

    @GetMapping
    List<Pais> buscarPaises() {
        return paisService.findAll();
    }

    @PostMapping
    ResponseEntity<?> inserirPais(@RequestBody Pais pais, UriComponentsBuilder uriBuilder) {
        paisService.save(pais);
        URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(pais);
    }

    @GetMapping(value = "/{id}")
    Optional<Pais> buscarPorId(@PathVariable Long id) {
        return paisService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    void deletarPorId(@PathVariable Long id) {
        paisService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Pais> alterarPais(@RequestBody Pais paisAlterado, @PathVariable Long id) {
/*
        Optional<Pais> busca = paisService.findById(id);
        Pais pais = busca.get();

        pais.setPib(paisAlterado.getPib());
        pais.setDescricao(paisAlterado.getDescricao());
        pais.setDataEmancipacao(paisAlterado.getDataEmancipacao());
        pais.setNumeroPopulacao(paisAlterado.getNumeroPopulacao());

        paisService.save(pais);*/
        return ResponseEntity.ok(paisService.save(paisAlterado));
    }

}