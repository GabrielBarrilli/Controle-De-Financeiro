package org.gabrielbarrilli.financeirocontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Caixa {

    private static double saldo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double entrada;

    private double saida;

    @OneToMany
    private Transacao transacao;
}
