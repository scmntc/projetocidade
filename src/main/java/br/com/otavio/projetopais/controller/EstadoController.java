package br.com.otavio.projetopais.controller;

import br.com.otavio.projetopais.model.Estado;
import br.com.otavio.projetopais.model.Pais;
import br.com.otavio.projetopais.services.Impl.EstadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin // Utilizar esta anotação para não ocorrer o problema do CORS
@RequestMapping(value = "/api/estados")
public class EstadoController {

    @Autowired
    private EstadoServiceImpl estadoService;

    @GetMapping
    List<Estado> buscarEstados() {
        return estadoService.findAll();
    }

    @GetMapping(value = "/{id}")
    Optional<Estado> buscarPorId(@PathVariable Long id) {
        return estadoService.findById(id);
    }

    @PostMapping
    ResponseEntity<?> inserirEstado(@RequestBody Estado estado, UriComponentsBuilder uriBuilder) {
        estado.setPais(estado.getPais());
        estadoService.save(estado);
        URI uri = uriBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(estado);
    }

    @DeleteMapping(value = "/{id}")
    void deletarPorId(@PathVariable Long id) {
        estadoService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Estado> atualizarEstado(@RequestBody Estado estadoAlterado, @PathVariable Long id){
        Optional<Estado> data = estadoService.findById(id);
        Estado estado = data.get();
        estado.setNome(estadoAlterado.getNome());
        estado.setUf(estadoAlterado.getUf());
        estado.setPais(estadoAlterado.getPais());
        return ResponseEntity.ok(estadoService.save(estado));
    }

}
