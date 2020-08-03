package com.luv2code.wef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.wef.dao.CustomerDAO;
import com.luv2code.wef.entity.Customer;

@Controller
public class MainController {
	
	@Autowired
	CustomerDAO dao;
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	
	@RequestMapping("/menu")
	public String menu(Model d) {
		
		List<Customer> customers = dao.getCustomers();
		d.addAttribute("customers", customers);
		for (Customer c : customers) {
			System.out.println(c);
		}
		return "menu";
	}
}
