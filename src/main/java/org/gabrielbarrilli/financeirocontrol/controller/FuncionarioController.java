package org.gabrielbarrilli.financeirocontrol.controller;

import org.gabrielbarrilli.financeirocontrol.model.Funcionario;
import org.gabrielbarrilli.financeirocontrol.model.dto.FuncionarioRequest;
import org.gabrielbarrilli.financeirocontrol.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @ResponseStatus(OK)
    @GetMapping("/getAllFuncionarios")
    public List<Funcionario> getFuncionarios() {
        return funcionarioService.findAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/createFuncionario")
    public Funcionario createFuncionario(@RequestBody FuncionarioRequest funcionarioRequest) {
        return funcionarioService.create(funcionarioRequest);
    }
}
