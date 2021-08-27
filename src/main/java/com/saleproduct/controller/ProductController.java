package com.saleproduct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saleproduct.entity.Product;
import com.saleproduct.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("list")
	public String list(Model model,@RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list =productService.findByCategory(cid.get());
			model.addAttribute("list", list);
		}else {
			List<Product> list =productService.findAll();
			model.addAttribute("list",list);
		} 
		return "home/home";
	}
}
