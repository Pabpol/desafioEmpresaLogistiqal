package com.polanco.desafioEmpresaLogistiqal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.polanco.desafioEmpresaLogistiqal.model.Product;
import com.polanco.desafioEmpresaLogistiqal.service.ProductService;
import com.polanco.desafioEmpresaLogistiqal.util.Util;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("")
	public String home(Model model, @RequestParam(defaultValue = "1") Integer page){ 
		
		Integer totalPaginas = productService.getPageCount(10).getValor();
		model.addAttribute("paginas", Util.getArregloPaginas(page, totalPaginas));
		model.addAttribute("paginaActual", page);
		model.addAttribute("products", productService.getPage(page-1, 10).getProducts());
		return "index";


		
	}

	@RequestMapping("/addProduct")
	public String addProduct(@ModelAttribute Product product, Model model,@RequestParam(defaultValue = "1") Integer page) {

		productService.addProduct(product);

		return home(model, page);
	}

	@RequestMapping("/selectProduct")
	public String seleccionLibro(@RequestParam Integer id, Model model, @RequestParam(defaultValue = "1") Integer page) {

		for (Product tempProduct : productService.listProducts().getProducts()) {
			if (id == tempProduct.getId()) {
				model.addAttribute("tempProduct", tempProduct);
				break;

			}

		}
		Integer totalPaginas = productService.getPageCount(10).getValor();
		model.addAttribute("paginas", Util.getArregloPaginas(page, totalPaginas));
		model.addAttribute("paginaActual", page);
		model.addAttribute("products", productService.getPage(page-1, 10).getProducts());
		return "index";
	}

	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Product product, Model model,@RequestParam(defaultValue = "1") Integer page) {
		
		
		Integer totalPaginas = productService.getPageCount(10).getValor();
		model.addAttribute("paginas", Util.getArregloPaginas(page, totalPaginas));
		model.addAttribute("paginaActual", page);
		model.addAttribute("products", productService.getPage(page-1, 10).getProducts());
		productService.updateProduct(product);

		return "index";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam(value = "id", required = false) Integer id, Model model,@RequestParam(defaultValue = "1") Integer page) {

		if (id != null) {
			for (Product tempProduct : productService.listProducts().getProducts()) {
				if (id == tempProduct.getId()) {
					productService.deleteProduct(tempProduct);
					break;

				}

			}

		}
		return home(model, page);
	}

	@RequestMapping(value = "/findProduct", method = RequestMethod.POST)
	public String findProduct(Model model, @RequestParam(name = "productName", required = false) String productName,@RequestParam(defaultValue = "1") Integer page) {
		if (productName.equals("")) {
			Integer totalPaginas = productService.getPageCount(10).getValor();
			model.addAttribute("paginas", Util.getArregloPaginas(page, totalPaginas));
			model.addAttribute("paginaActual", page);
			model.addAttribute("products", productService.getPage(page-1, 10).getProducts());

		} else {
			model.addAttribute("products", productService.findProductByName(productName).getProducts());
		}

		return "index";
	}
}
