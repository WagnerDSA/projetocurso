package com.wagnerpupo.CursoMC.services;



import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.wagnerpupo.CursoMC.domain.Categoria;
import com.wagnerpupo.CursoMC.repositories.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find (Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null));
		} 

public Categoria insert (Categoria obj){
	obj.setId(null);
	return repo.save(obj);

}
public Categoria update (Categoria obj){

	find(obj.getId());
	return repo.save(obj);
}

public void delete (Integer id) {

	find(id);
	try{
	repo.deleteById(id);
}

catch(DataIntegrityViolationException e){

}
}

public List<Categoria> findAll() {

	return repo.findAll();

}
}

