package org.gabrielbarrilli.financeirocontrol.controller;

import org.gabrielbarrilli.financeirocontrol.model.Caixa;
import org.gabrielbarrilli.financeirocontrol.service.CaixaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    private final CaixaService caixaService;

    public CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @GetMapping("/getAllCaixa")
    public List<Caixa> getAll() {
        return caixaService.findAll();
    }
}


