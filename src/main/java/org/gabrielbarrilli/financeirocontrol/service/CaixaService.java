package org.gabrielbarrilli.financeirocontrol.service;

import org.gabrielbarrilli.financeirocontrol.model.Caixa;
import org.gabrielbarrilli.financeirocontrol.model.Transacao;
import org.gabrielbarrilli.financeirocontrol.model.dto.CaixaRequest;
import org.gabrielbarrilli.financeirocontrol.repository.CaixaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    @Transactional
    public void create(Transacao transacao) {
        Caixa caixa = new Caixa();

        caixa.setValor(transacao.getTotal());
        caixa.setTransacao(transacao);

        caixaRepository.save(caixa);
    }

    @Transactional(readOnly = true)
    public List<Caixa> findAll() {
        return caixaRepository.findAll();
    }
}
