package br.com.otavio.projetopais.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pais")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(name = "pib")
    private BigDecimal pib;

    @Column(name = "dataempancipacao", nullable = false)
    private Date dataEmancipacao;

    @Column(name = "numeropopulacao")
    private BigInteger numeroPopulacao;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference // Para não ocorrer json loop
    private List<Estado> estados = new ArrayList<Estado>();

}
