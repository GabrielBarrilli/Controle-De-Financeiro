package org.gabrielbarrilli.financeirocontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @Id
    @Column(name = "id_transacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao_transacao")
    private String descricao;

    @Column(name = "taxa_transacao")
    private Double taxa;

    @Column(name = "total_transacao")
    private Double total;

    @Column(name = "data_transacao")
    private LocalDateTime dataTransacao;

    @ManyToOne
    @JoinColumn(name = "fk_item_transacao")
    private Item item;

    @OneToOne
    @JoinColumn(name = "fk_categoria_transacao")
    private TransacaoCategoria categoria;

    @ManyToOne
    @JoinColumn(name = "fk_funcionario_transacao")
    private Funcionario funcionario;
}
