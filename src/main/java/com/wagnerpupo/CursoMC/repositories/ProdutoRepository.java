package com.wagnerpupo.CursoMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wagnerpupo.CursoMC.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{
	
	

}
