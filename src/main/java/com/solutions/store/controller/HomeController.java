package com.solutions.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.store.model.Invoice;
import com.solutions.store.service.InvoiceService;

@RestController
public class HomeController {

	@Autowired
	InvoiceService employeeService;
	
	@RequestMapping("/test")
	public Invoice getInvoice(@RequestParam int id) {
		return employeeService.getInvoice(id);
	}
}
