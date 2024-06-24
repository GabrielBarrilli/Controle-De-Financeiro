package org.gabrielbarrilli.financeirocontrol.controller;

import org.gabrielbarrilli.financeirocontrol.model.Transacao;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoRequest;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoResponse;
import org.gabrielbarrilli.financeirocontrol.service.TransacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @ResponseStatus(OK)
    @GetMapping("/getAllTransacoes")
    public List<TransacaoResponse> get() {
        return transacaoService.listarTodos();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/registrarTransacao")
    public Transacao registrarTransacao(Long idItem, Long idCategoria, @RequestBody TransacaoRequest transacaoRequest) {
           return transacaoService.salvar(idItem, idCategoria, transacaoRequest);
    }
}
