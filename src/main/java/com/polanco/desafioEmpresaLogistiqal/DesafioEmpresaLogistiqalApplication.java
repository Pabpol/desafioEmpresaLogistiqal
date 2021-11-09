package com.polanco.desafioEmpresaLogistiqal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.polanco.desafioEmpresaLogistiqal.model.Product;
import com.polanco.desafioEmpresaLogistiqal.repository.ProductRepository;



@SpringBootApplication
public class DesafioEmpresaLogistiqalApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DesafioEmpresaLogistiqalApplication.class, args);
		
		
		//AÑADIR 100 PRODUCTOS A BD
//		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
//		ProductRepository productRepository = acac.getBean(ProductRepository.class);
//		Random random = new Random();
//		int[] precios = {5000, 10000, 15000, 20000};
//		int[] stocks = {0, 5 , 10 , 15};
//		List<Product> products = new ArrayList<Product>();
//		for(int i = 1 ; i <= 100 ; i++) {
//			
//			Product product = new Product();
//			product.setProductName(String.format("Produto%d", i));
//			product.setPrice(precios[random.nextInt(precios.length)]);
//			product.setStock(stocks[random.nextInt(stocks.length)]);
//			
//			products.add(product);			
//		}
//		
//		productRepository.saveAll(products);
		
	}

}
