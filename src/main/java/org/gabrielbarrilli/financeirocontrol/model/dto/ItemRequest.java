package org.gabrielbarrilli.financeirocontrol.model.dto;

public record ItemRequest(
        int quantidade,

        double valor,

        String nome,

        String descricao
) {
}
