package br.com.otavio.projetopais.services.Impl;

import br.com.otavio.projetopais.model.Estado;
import br.com.otavio.projetopais.model.Pais;
import br.com.otavio.projetopais.repository.EstadoRepository;
import br.com.otavio.projetopais.repository.PaisRepository;
import br.com.otavio.projetopais.services.EstadoService;
import br.com.otavio.projetopais.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public Optional<Estado> findById(Long id) {
      return estadoRepository.findById(id);
    }

    @Override
    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        estadoRepository.deleteById(id);
    }
}

