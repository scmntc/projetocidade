package br.com.otavio.projetopais.repository;

import br.com.otavio.projetopais.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
