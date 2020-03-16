package br.com.otavio.projetopais.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "estado")
public class Estado  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "uf", nullable =  false)
    private String uf;

    @ManyToOne
    @JoinColumn(name="pais_id")
    @JsonBackReference // Para não ocorrer json loop
    private Pais pais;
}
