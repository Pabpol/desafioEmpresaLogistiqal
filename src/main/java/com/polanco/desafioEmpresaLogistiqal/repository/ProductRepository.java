package com.polanco.desafioEmpresaLogistiqal.repository;

import org.springframework.data.repository.CrudRepository;

import com.polanco.desafioEmpresaLogistiqal.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	

}
