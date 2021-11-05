package com.polanco.desafioEmpresaLogistiqal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.polanco.desafioEmpresaLogistiqal.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	public List<Product> findByProductName(String productName);
	

}
