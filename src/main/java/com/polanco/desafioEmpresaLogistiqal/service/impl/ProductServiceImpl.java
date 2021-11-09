package com.polanco.desafioEmpresaLogistiqal.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.polanco.desafioEmpresaLogistiqal.VO.NumberVO;
import com.polanco.desafioEmpresaLogistiqal.VO.ProductVO;
import com.polanco.desafioEmpresaLogistiqal.model.Product;
import com.polanco.desafioEmpresaLogistiqal.model.ProductPage;
import com.polanco.desafioEmpresaLogistiqal.repository.ProductRepository;
import com.polanco.desafioEmpresaLogistiqal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private ProductVO productVO;

	@Override
	public ProductVO addProduct(Product product) {
		
		productVO = new ProductVO(new ArrayList<Product>(),"Ocurrió un error al agregar el producto","1");
		try {
			productRepository.save(product);
			productVO.setProducts(new ArrayList<Product>());
			productVO.setMesage("El producto fué agregado con éxito");
			productVO.setCoode("0");
		} catch (Exception e) {
			logger.error(String.format("Error en ProductService: buscar todo:" + e));
		}
	
		return productVO;
	}

	@Override
	public ProductVO updateProduct(Product product) {
		productVO = new ProductVO(new ArrayList<Product>(),"Ocurrió un error al modificar el producto","1");
		try {
			productRepository.save(product);
			productVO.setProducts(new ArrayList<Product>());
			productVO.setMesage("El producto fué modificado con éxito");
			productVO.setCoode("0");
		} catch (Exception e) {
			logger.error(String.format("Error en ProductService: buscar todo:" + e));
		}
	
		return productVO;
	}

	@Override
	public ProductVO listProducts( ) {
		productVO = new ProductVO(new ArrayList<Product>(),"Ocurrió un error al listar los productos","1");
		try {
		
			productVO.setProducts(productRepository.findAll());
			productVO.setMesage("Los productos fueron listados con éxito");
			productVO.setCoode("0");
		} catch (Exception e) {
			logger.error(String.format("Error en ProductService: buscar todo:" + e));
		}
	
		return productVO;
	}

	@Override
	public ProductVO findProductByName(String productName) {
		productVO = new ProductVO(new ArrayList<Product>(),"Ocurrió un error al buscar el producto","1");
		try {
			
			productVO.setProducts(productRepository.findByProductName(productName));
			productVO.setMesage("El producto fué agregado con éxito");
			productVO.setCoode("0");
		} catch (Exception e) {
			logger.error(String.format("Error en ProductService: buscar todo:" + e));
		}
	
		return productVO;
	}

	@Override
	public ProductVO deleteProduct(Product product) {
		productVO = new ProductVO(new ArrayList<Product>(),"Ocurrió un error al eliminar el producto","1");
		try {
			productRepository.delete(product);
			productVO.setProducts(new ArrayList<Product>());
			productVO.setMesage("El producto fué eliminado con éxito");
			productVO.setCoode("0");
		} catch (Exception e) {
			logger.error(String.format("Error en ProductService: buscar todo:" + e));
		}
	
		return productVO;
	}

	@Override
	public ProductVO getPage(Integer page, Integer countPage) {
		productVO = new ProductVO(new ArrayList<Product>(),"Ocurrió un error al eliminar el producto","1");
		try {
			Pageable pageable = PageRequest.of(page, countPage);
			Page<Product> responsePage = productRepository.findAll(pageable);
			
			productVO.setProducts(responsePage.getContent());
			productVO.setMesage("El producto fué eliminado con éxito");
			productVO.setCoode("0");
		} catch (Exception e) {
			logger.error(String.format("Error en ProductService: buscar todo:" + e));
		}
	
		return productVO;
	}

	@Override
	public NumberVO getPageCount(long registrosPorPagina) {
		NumberVO respuesta = new NumberVO(0, "Ha ocurrido un error", "109" );
		try {
			long registros = productRepository.count();
			if(registrosPorPagina == 0 && registros == 0) {
				respuesta.setValor(1);
			}else {
				respuesta.setValor((int) ((registros/registrosPorPagina) + (registros % registrosPorPagina == 0 ? 0 : 1)));
			}
			respuesta.setCoode("201");
			respuesta.setMesage(String.format("Hay %d paginas", respuesta.getValor()));
		} catch (Exception e) {
			logger.trace("Usuario Service: Error en getPageCount", e);
		}
		return respuesta;
	}
	
	

	
}
