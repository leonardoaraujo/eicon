package br.com.eicon.leonardo.eicon.dominio.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.eicon.leonardo.eicon.dominio.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


	@Query(value = "SELECT c from Cliente c"
			+ " WHERE 1=1 AND (:numeroControle IS NULL OR c.numeroControle = :numeroControle)"
			+ " AND (:dataCadastro IS NULL OR c.dataCadastro = :dataCadastro)"
			+ " ORDER BY c.nome")
	@Transactional(readOnly = true)
	List<Cliente> pesquisaPorParametros(@Param("numeroControle") Long numeroControle, 
			@Param("dataCadastro") LocalDate dataCadastro);
}
