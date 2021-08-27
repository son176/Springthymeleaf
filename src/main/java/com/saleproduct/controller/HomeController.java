package com.saleproduct.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.saleproduct.entity.Product;
import com.saleproduct.service.ProductService;
        
 
    
@Controller
@RequestMapping("store") 
public class HomeController {
	@Autowired
	ProductService productservice;
	@GetMapping("home")  
	public String index(Model moel) {
		List<Product> list =productservice.findAll();
		moel.addAttribute("list",list);
		return "home/home";
	}
	@GetMapping("detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		Product item =productservice.findById(id);
		model.addAttribute("item", item);
		return "home/detail"; 
	}
	 
}
