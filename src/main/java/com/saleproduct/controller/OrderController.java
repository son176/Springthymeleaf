package com.saleproduct.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saleproduct.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@GetMapping("checkout")
	public String checkout(Model model) {
		return "order/checkout";
	}
	@GetMapping("list")
	public String list(Model model,HttpServletRequest request) {
		String username =request.getRemoteUser();
		model.addAttribute("orders",orderService.findByUsername(username));
		return "order/list";
	} 
	@GetMapping("detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}  
}
