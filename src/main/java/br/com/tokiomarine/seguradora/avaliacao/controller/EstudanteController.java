package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	EstudanteRepository repo;
	
	EstudanteController (EstudanteRepository estudanteRepository){
		this.repo = estudanteRepository;
	}

	@PutMapping(value="criar")
	public String iniciarCastrado(@RequestBody Estudante estudante) {
		
		return "cadastrar-estudante";
	}

	@GetMapping("listar")
	public List listarEstudantes() {
		return repo.findAll();
	}

	@PostMapping(value="add")
	public Estudante adicionarEstudante(@RequestBody Estudante estudante) {
		return repo.save(estudante);
	}
	/*
	@GetMapping("editar/{id}")
	public List<Estudante> exibirEdicaoEstudante(Long id, Model model) {
		return repo.findById(id);
	}
	*/
	@PutMapping(value="atualizar/{id}")
	public ResponseEntity atualizarEstudante(@PathVariable("id") long id, @RequestBody Estudante estudante) {

		return  repo.findById(id)
	              .map(record -> {
	                  record.setName(estudante.getName());
	                  record.setEmail(estudante.getEmail());
	                  record.setPhone(estudante.getPhone());
	                  Estudante updated = repo.save(record);
	                  return ResponseEntity.ok().body(updated);
	              }).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value="apagar/{id}")
	public ResponseEntity apagarEstudante(@PathVariable("id") long id) {
		return repo.findById(id)
	              .map(record -> {
	                  repo.deleteById(id);
	                  return ResponseEntity.ok().build();
	              }).orElse(ResponseEntity.notFound().build());
	}
}
