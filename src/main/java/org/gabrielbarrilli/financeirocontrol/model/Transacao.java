package org.gabrielbarrilli.financeirocontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private double valorProduto;

    private double taxa;

    private double total;

    private LocalDateTime dataTransacao;

    @ManyToOne
    private Item item;

    @OneToOne
    private TransacaoCategoria categoria;

    @ManyToOne
    private Funcionario funcionario;
}
