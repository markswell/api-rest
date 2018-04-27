package com.markswell.apirest.repository;

import java.util.List;

import com.markswell.apirest.model.Lancamento;
import com.markswell.apirest.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
