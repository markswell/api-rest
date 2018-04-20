package com.markswell.apirest.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.markswell.apirest.model.Pessoa;
import com.markswell.apirest.repository.PessoaRepository;

@Service
public class PessoaServices {
	@Autowired
	public PessoaRepository repository;

	public PessoaServices() {
	}
	
	
	public Pessoa atualizar(Pessoa pessoa, Long codigo) {
		Optional<Pessoa> findById = repository.findById(codigo);
		Pessoa pessoaRetorno = findById.isPresent() ? findById.get() : null;

		if (pessoaRetorno == null)
			throw new EmptyResultDataAccessException(1);
		BeanUtils.copyProperties(pessoa, pessoaRetorno, "codigo");
		return repository.save(pessoaRetorno);
	}
	
}