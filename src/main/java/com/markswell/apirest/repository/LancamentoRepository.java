package com.markswell.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markswell.apirest.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
