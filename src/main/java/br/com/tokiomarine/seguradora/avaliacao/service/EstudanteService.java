package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

public interface EstudanteService {

	List buscarEstudantes();

	void cadastrarEstudante(@Valid Estudante estudante);

	ResponseEntity<Estudante> buscarEstudante(long id);

	void atualizarEstudante(@Valid Estudante estudante);
}
