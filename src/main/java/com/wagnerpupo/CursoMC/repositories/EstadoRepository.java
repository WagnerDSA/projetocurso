package com.wagnerpupo.CursoMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wagnerpupo.CursoMC.domain.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{
	
	

}
