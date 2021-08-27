package com.saleproduct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAdminController {
	@RequestMapping({"/","/home/index"})
		public String home() {
			return "redirect:/product/list";
		}
	
	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		return "redirect:/admin/index.html";
	}
	}
