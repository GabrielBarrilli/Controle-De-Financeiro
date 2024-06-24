package org.gabrielbarrilli.financeirocontrol.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeirocontrol.model.Transacao;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoRequest;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoResponse;
import org.gabrielbarrilli.financeirocontrol.repository.FuncionarioRepository;
import org.gabrielbarrilli.financeirocontrol.repository.ItemRepository;
import org.gabrielbarrilli.financeirocontrol.repository.TransacaoCategoriaRepository;
import org.gabrielbarrilli.financeirocontrol.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final ItemRepository itemRepository;
    private final TransacaoCategoriaRepository transacaoCategoriaRepository;
    private final CaixaService caixaService;
    private final FuncionarioRepository funcionarioRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, ItemRepository itemRepository, TransacaoCategoriaRepository transacaoCategoriaRepository, CaixaService caixaService, FuncionarioRepository funcionarioRepository) {
        this.transacaoRepository = transacaoRepository;
        this.itemRepository = itemRepository;
        this.transacaoCategoriaRepository = transacaoCategoriaRepository;
        this.caixaService = caixaService;
        this.funcionarioRepository = funcionarioRepository;
    }

    private TransacaoResponse transacaoResponse(Transacao transacao) {
        return new TransacaoResponse(
                transacao.getId(),
                transacao.getDescricao(),
                transacao.getTaxa(),
                transacao.getTotal(),
                transacao.getItem().getNome(),
                transacao.getCategoria().getNome(),
                transacao.getFuncionario().getNome(),
                transacao.getFuncionario().getMatricula()
        );
    }

    @Transactional()
    public Transacao salvar(Long idItem, Long categoriaId, Long idFuncionario, TransacaoRequest transacaoRequest) {
        Transacao transacao = new Transacao();

        var item = itemRepository.findById(idItem)
                        .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
        var categoria = transacaoCategoriaRepository.findById(categoriaId)
                        .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        var funcionario = funcionarioRepository.findById(idFuncionario)
                        .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado"));

        transacao.setItem(item);
        transacao.setDescricao(transacaoRequest.descricao());
        transacao.setDataTransacao(LocalDateTime.now());
        transacao.setTaxa(item.getValor() * 0.05);
        transacao.setTotal(item.getValor() + transacao.getTaxa());
        transacao.setCategoria(categoria);
        transacao.setFuncionario(funcionario);

        caixaService.create(transacao);

        return transacaoRepository.save(transacao);
    }

    @Transactional(readOnly = true)
    public List<TransacaoResponse> listarTodos() {
        List<Transacao> transacao = transacaoRepository.findAll();

        List<TransacaoResponse> transacaoResponses = new ArrayList<>();

        transacao.forEach(transacao1 -> {
            var response = transacaoResponse(transacao1);
            transacaoResponses.add(response);
        });

        return transacaoResponses;

    }

    @Transactional(readOnly = true)
    public Transacao buscarPorId(Long id) {

        return transacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transação não encontrada"));
    }
}
