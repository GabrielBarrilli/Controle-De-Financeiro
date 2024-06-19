package org.gabrielbarrilli.financeirocontrol.repository;

import org.gabrielbarrilli.financeirocontrol.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
