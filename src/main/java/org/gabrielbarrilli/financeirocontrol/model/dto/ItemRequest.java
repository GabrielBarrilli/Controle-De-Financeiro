package org.gabrielbarrilli.financeirocontrol.model.dto;

public record ItemRequest(
        double valor,

        String nome,

        String descricao
) {
}
