package org.gabrielbarrilli.financeirocontrol.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeirocontrol.model.Funcionario;
import org.gabrielbarrilli.financeirocontrol.model.dto.FuncionarioRequest;
import org.gabrielbarrilli.financeirocontrol.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional()
    public Funcionario create(FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setCpf(funcionarioRequest.cpf());
        funcionario.setMatricula(funcionarioRequest.matricula());

        return funcionarioRepository.save(funcionario);
    }

    @Transactional(readOnly = true)
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Funcionario findById(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }

    @Transactional(readOnly = true)
    public void deleteById(Long idFuncionario) {
        var funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado"));

        funcionarioRepository.delete(funcionario);
    }

    @Transactional
    public Funcionario update(Long idFuncionario, FuncionarioRequest funcionarioRequest) {
        var funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado"));

        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setCpf(funcionarioRequest.cpf());
        funcionario.setMatricula(funcionarioRequest.matricula());

        return funcionarioRepository.save(funcionario);
    }
}
