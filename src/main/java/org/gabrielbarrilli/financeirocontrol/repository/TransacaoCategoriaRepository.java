package org.gabrielbarrilli.financeirocontrol.repository;

import org.gabrielbarrilli.financeirocontrol.model.TransacaoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoCategoriaRepository extends JpaRepository<TransacaoCategoria, Long> {
}
