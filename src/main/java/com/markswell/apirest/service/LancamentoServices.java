package com.markswell.apirest.service;

import com.markswell.apirest.model.Lancamento;
import com.markswell.apirest.model.Pessoa;
import com.markswell.apirest.repository.LancamentoRepository;
import com.markswell.apirest.repository.PessoaRepository;
import com.markswell.apirest.service.excepition.PessoaInexistenteOuInativaExcepition;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LancamentoServices {

    @Autowired
    private LancamentoRepository repository;
    
    @Autowired
    private PessoaRepository pessoaRepository;


	public Lancamento salvar(Lancamento lancamento) throws PessoaInexistenteOuInativaExcepition {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		if (!pessoa.isPresent() || !pessoa.get().isAtivo())
			throw new PessoaInexistenteOuInativaExcepition();
        return repository.save(lancamento);

    }
}
