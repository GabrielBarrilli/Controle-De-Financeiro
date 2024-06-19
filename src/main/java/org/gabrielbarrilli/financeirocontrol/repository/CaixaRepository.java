package org.gabrielbarrilli.financeirocontrol.repository;

import org.gabrielbarrilli.financeirocontrol.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
}
