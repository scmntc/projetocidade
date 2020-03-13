package br.com.otavio.projetopais.model.TO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaisTO {

    private Long id;
    private String descricao;
    private BigDecimal pib;
}
