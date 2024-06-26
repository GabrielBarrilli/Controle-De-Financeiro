package org.gabrielbarrilli.financeirocontrol.repository;

import org.gabrielbarrilli.financeirocontrol.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {

    @Query(value = "SELECT c FROM Caixa c ORDER BY c.id DESC LIMIT 1")
    Caixa findSaldo();

    @Query(value = "SELECT c.saldo FROM Caixa c WHERE c.saldo IS NOT NULL ORDER BY c.id DESC LIMIT 1")
    Double calcularSaldoTotal();
}
