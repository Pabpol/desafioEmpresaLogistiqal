package com.polanco.desafioEmpresaLogistiqal.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.polanco.desafioEmpresaLogistiqal.VO.NumberVO;
import com.polanco.desafioEmpresaLogistiqal.VO.ProductVO;
import com.polanco.desafioEmpresaLogistiqal.model.Product;
import com.polanco.desafioEmpresaLogistiqal.model.ProductPage;

public interface ProductService {
	
	public ProductVO addProduct(Product prodcut);
	public ProductVO updateProduct(Product product);
	public ProductVO listProducts( );
	public ProductVO findProductByName(String prodcutName);
	public ProductVO deleteProduct(Product prodcut);
	public ProductVO getPage(Integer page, Integer countPage);
	public NumberVO getPageCount(long registrosPorPagina); 

}
