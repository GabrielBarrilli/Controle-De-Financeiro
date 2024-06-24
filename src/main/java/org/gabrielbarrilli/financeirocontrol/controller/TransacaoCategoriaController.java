package org.gabrielbarrilli.financeirocontrol.controller;

import org.gabrielbarrilli.financeirocontrol.model.TransacaoCategoria;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoCategoriaRequest;
import org.gabrielbarrilli.financeirocontrol.service.TransacaoCategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/categoria")
public class TransacaoCategoriaController {

    private final TransacaoCategoriaService transacaoCategoriaService;

    public TransacaoCategoriaController(TransacaoCategoriaService transacaoCategoriaService) {
        this.transacaoCategoriaService = transacaoCategoriaService;
    }

    @ResponseStatus(OK)
    @GetMapping("/getAllCategorias")
    public List<TransacaoCategoria> getCategoria() {
        return transacaoCategoriaService.getAllCategorias();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/createCategoria")
    public TransacaoCategoria createCategoria(@RequestBody TransacaoCategoriaRequest transacaoCategoriaRequest) {
        return transacaoCategoriaService.createCategoria(transacaoCategoriaRequest);
    }
}
