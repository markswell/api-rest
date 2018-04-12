package com.markswell.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markswell.apirest.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
