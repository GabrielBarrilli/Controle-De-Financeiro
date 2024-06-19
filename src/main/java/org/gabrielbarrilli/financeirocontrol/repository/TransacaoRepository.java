package org.gabrielbarrilli.financeirocontrol.repository;

import org.gabrielbarrilli.financeirocontrol.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
