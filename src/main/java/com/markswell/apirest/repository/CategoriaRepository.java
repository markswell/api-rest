package com.markswell.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markswell.apirest.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
