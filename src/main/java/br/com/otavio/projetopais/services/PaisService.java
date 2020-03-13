package br.com.otavio.projetopais.services;

import br.com.otavio.projetopais.model.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisService{

    Optional<Pais> findById(Long id);

    Pais save(Pais pais);

    List<Pais> findAll();

    void deleteById(Long id);

}