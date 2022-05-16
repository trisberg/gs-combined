package com.example.servingwebcontent;

import java.util.ArrayList;
import java.util.List;

import com.example.accessingdatajpa.Customer;
import com.example.accessingdatajpa.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customers;

	@GetMapping("/customers")
	public String greeting(Model model) {
		List<Customer> customerList = new ArrayList<>();
		customers.findAll().forEach(customerList::add);
		model.addAttribute("customerList", customerList);
		return "customers";
	}

}
