package com.solutions.store.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.store.model.Invoice;
import com.solutions.store.service.InvoiceService;

@RestController
public class HomeController {

	@Autowired
	InvoiceService employeeService;

	@ExceptionHandler(Exception.class)
	public void handleException() {
		System.out.println("error");
	}

	@RequestMapping("/test")
	public ResponseEntity<Integer> getInvoice(@RequestParam int id) throws Exception {

		Optional<Invoice> invoice = employeeService.getInvoice(id);
		if (invoice.isPresent()) {
			return ResponseEntity.ok(invoice.get().getNetPayableAmount());

		}
		throw new Exception("The invoice of selected id " + id + " is not exist");
	}
}
