package com.markswell.apirest.resource;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.markswell.apirest.service.LancamentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.markswell.apirest.event.RecursoCriadoEvent;
import com.markswell.apirest.model.Lancamento;
import com.markswell.apirest.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	@Autowired
	private LancamentoRepository repository;
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private LancamentoServices services;
	
	@GetMapping
	public ResponseEntity<List<Lancamento>> listar(){
		List<Lancamento> lancamento = repository.findAll();
		return !lancamento.isEmpty() ? ResponseEntity.ok(repository.findAll()) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Lancamento> criar(@Valid	@RequestBody	Lancamento lancamento, HttpServletResponse response) {
		Lancamento lancamentoSalvo = services.salvar(lancamento);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Lancamento> lancamento = repository.findById(codigo);
		return !lancamento.isPresent() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lancamento); 
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		repository.deleteById(codigo);
	} 
}
