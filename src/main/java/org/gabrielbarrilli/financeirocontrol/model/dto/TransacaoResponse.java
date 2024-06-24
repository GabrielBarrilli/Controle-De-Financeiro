package org.gabrielbarrilli.financeirocontrol.model.dto;

public record TransacaoResponse(
        Long transacaoId,
        String descricao,
        Double taxa,
        Double total,
        String item,
        String categoria,
        String funcionario,
        String matriculaFuncionario
) {
}
