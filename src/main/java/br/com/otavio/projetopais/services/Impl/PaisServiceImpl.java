package br.com.otavio.projetopais.services.Impl;

import br.com.otavio.projetopais.model.Pais;
import br.com.otavio.projetopais.repository.PaisRepository;
import br.com.otavio.projetopais.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Optional<Pais> findById(Long id) {
      return paisRepository.findById(id);
    }

    @Override
    public Pais save(Pais pais) {
        if (pais.getId() != null) {
            Pais local = findById(pais.getId()).orElse(null);
            if (local.getDataEmancipacao() != null && pais.getDataEmancipacao() == null) {
                pais.setDataEmancipacao(local.getDataEmancipacao());
            }
        }
        return paisRepository.save(pais);
    }

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }
}

