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
    private int id;

    private String descricao;

    private double valorProduto;

    private double taxa = 0.05 * valorProduto;

    private double total = valorProduto + taxa;

    private LocalDateTime dataTransacao;

    @ManyToOne
    private TransacaoCategoria categoriaId;
}
