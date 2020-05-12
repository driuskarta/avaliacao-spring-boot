package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

// TODO Efetue a implementação dos métodos da classe service
public class EstudanteServiceImpl implements EstudanteService {

	EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		
		repository.save(estudante);

	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {

	}

	@Override
	public List buscarEstudantes() {
		
		
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Estudante> buscarEstudante(@PathVariable long id) {

		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
		        .orElse(ResponseEntity.notFound().build());
	}

}
