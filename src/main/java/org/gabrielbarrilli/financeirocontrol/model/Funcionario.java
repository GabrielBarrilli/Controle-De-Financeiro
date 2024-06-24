package org.gabrielbarrilli.financeirocontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @Column(name = "id_funcionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_funcionario")
    private String nome;

    @Column(name = "cpf_funcionario")
    private String cpf;

    @Column(name = "matricula_funcionario")
    private String matricula;
}
