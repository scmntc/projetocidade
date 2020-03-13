package br.com.otavio.projetopais.repository;

import br.com.otavio.projetopais.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
