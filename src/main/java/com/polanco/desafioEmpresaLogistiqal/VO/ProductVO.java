package com.polanco.desafioEmpresaLogistiqal.VO;


import com.polanco.desafioEmpresaLogistiqal.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	

	private Iterable<Product> products;
	private String mesage;
	private String coode;

}
