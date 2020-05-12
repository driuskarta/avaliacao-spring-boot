package br.com.tokiomarine.seguradora.avaliacao.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

	List<Estudante> findByName(String name);
	
}
