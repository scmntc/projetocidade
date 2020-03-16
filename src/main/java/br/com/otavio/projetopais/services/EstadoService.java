package br.com.otavio.projetopais.services;

import br.com.otavio.projetopais.model.Estado;
import br.com.otavio.projetopais.model.Pais;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    Optional<Estado> findById(Long id);

    Estado save(Estado estado);

    List<Estado> findAll();

    void deleteById(Long id);
}
