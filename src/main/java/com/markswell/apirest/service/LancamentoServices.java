package com.markswell.apirest.service;

import com.markswell.apirest.model.Lancamento;
import com.markswell.apirest.repository.LancamentoRepository;
import com.markswell.apirest.service.excepition.PessoaInexistenteOuInativaExcepition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LancamentoServices {

    @Autowired
    private LancamentoRepository repository;


    public Lancamento salvar(Lancamento lancamento) throws PessoaInexistenteOuInativaExcepition{
        try {
            if(lancamento.getPessoa() == null || !lancamento.getPessoa().isAtivo())
                throw new PessoaInexistenteOuInativaExcepition();

        } catch (Exception e) {}
        return repository.save(lancamento);

    }
}
