package org.gabrielbarrilli.financeirocontrol.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeirocontrol.model.TransacaoCategoria;
import org.gabrielbarrilli.financeirocontrol.model.dto.TransacaoCategoriaRequest;
import org.gabrielbarrilli.financeirocontrol.repository.TransacaoCategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransacaoCategoriaService {

    private final TransacaoCategoriaRepository transacaoCategoriaRepository;

    public TransacaoCategoriaService(TransacaoCategoriaRepository transacaoCategoriaRepository) {
        this.transacaoCategoriaRepository = transacaoCategoriaRepository;
    }

    @Transactional
    public TransacaoCategoria createCategoria(TransacaoCategoriaRequest transacaoCategoriaRequest) {
        var transacaoCategoria = new TransacaoCategoria();

        transacaoCategoria.setNome(transacaoCategoriaRequest.nome());

        return transacaoCategoriaRepository.save(transacaoCategoria);
    }

    @Transactional(readOnly = true)
    public List<TransacaoCategoria> getAllCategorias() {
        return transacaoCategoriaRepository.findAll();
    }

    @Transactional
    public TransacaoCategoria updateCategoria(Long idCateoria, TransacaoCategoriaRequest transacaoCategoriaRequest) {
        var transacaoCategoria = transacaoCategoriaRepository.findById(idCateoria)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));

        transacaoCategoria.setNome(transacaoCategoriaRequest.nome());

        return transacaoCategoriaRepository.save(transacaoCategoria);
    }
}
