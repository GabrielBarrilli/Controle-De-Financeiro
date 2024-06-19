package org.gabrielbarrilli.financeirocontrol.service;

import org.gabrielbarrilli.financeirocontrol.model.Caixa;
import org.gabrielbarrilli.financeirocontrol.model.Transacao;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoRequest;
import org.gabrielbarrilli.financeirocontrol.repository.ItemRepository;
import org.gabrielbarrilli.financeirocontrol.repository.TransacaoCategoriaRepository;
import org.gabrielbarrilli.financeirocontrol.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final ItemRepository itemRepository;
    private final TransacaoCategoriaRepository transacaoCategoriaRepository;
    private final CaixaService caixaService;

    public TransacaoService(TransacaoRepository transacaoRepository, ItemRepository itemRepository, TransacaoCategoriaRepository transacaoCategoriaRepository, CaixaService caixaService) {
        this.transacaoRepository = transacaoRepository;
        this.itemRepository = itemRepository;
        this.transacaoCategoriaRepository = transacaoCategoriaRepository;
        this.caixaService = caixaService;
    }

    @Transactional()
    public Transacao salvar(Long idItem, Long categoriaId, TransacaoRequest transacaoRequest) {
        Transacao transacao = new Transacao();

        var item = itemRepository.findById(idItem)
                        .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
        var categoria = transacaoCategoriaRepository.findById(categoriaId)
                        .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        transacao.setDescricao(transacaoRequest.descricao());

        transacao.setDataTransacao(LocalDateTime.now());
        transacao.setValorProduto(item.getValor());

        transacao.setTaxa(transacao.getValorProduto()*0.05);

        transacao.setTotal(transacao.getValorProduto()+transacao.getTaxa());

        transacao.setCategoria(categoria);

        caixaService.create(transacao);

        return transacaoRepository.save(transacao);
    }

    @Transactional(readOnly = true)
    public List<Transacao> listarTodos() {
        return transacaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Transacao buscarPorId(Long id) {

        return transacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transação não encontrada"));
    }
}
