package org.gabrielbarrilli.financeirocontrol.model.dto;

public record FuncionarioRequest(
        String nome,

        String cpf,

        String matricula
) {
}