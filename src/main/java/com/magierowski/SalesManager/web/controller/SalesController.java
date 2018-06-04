package com.magierowski.SalesManager.web.controller;

import static java.math.BigDecimal.valueOf;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magierowski.SalesManager.domain.model.Client;
import com.magierowski.SalesManager.domain.model.Issuer;
import com.magierowski.SalesManager.domain.model.Invoice;
import com.magierowski.SalesManager.domain.model.InvoiceSummary;
import com.magierowski.SalesManager.domain.model.Order;
import com.magierowski.SalesManager.domain.model.OrderItem;
import com.magierowski.SalesManager.domain.service.InvoiceGenerator;

@RestController
public class SalesController {
	
	/**
	 * Returns invoice for the last order.
	 * @return
	 */
	@GetMapping("/client/{clientId}/invoice")
	public ResponseEntity<Invoice> generateInvoiceForLastCustomerOrder(@PathVariable String clientId) {
		Client client = new Client("Jan Bosko", "ul. Kalinowa 177/2 41-208 Sosnowiec", "90257855698");
		Issuer issuer = new Issuer ("Marek Magierowski", "ul. Wesoła 5/4", "41-200", "Sosnowiec" , "88031814539", "ING o/Sosnowiec" , "89-1020-3682-91828-7278-82831");
		
		Order order = new Order(client.getId());
		order.addItem(new OrderItem("klocki", 1, valueOf(100) , valueOf(0.22)));
		order.addItem(new OrderItem("konik", 1, valueOf(100), valueOf(0.1)));
		order.addItem(new OrderItem("puzzle", 10, valueOf(10), valueOf(0.5)));
		
		Invoice invoice = new Invoice(order, client, issuer);		
		
		return ResponseEntity.ok(invoice);
	}
	
	@PostMapping("/client")
	public ResponseEntity createNewClient(@RequestBody Client client) throws URISyntaxException {
		System.out.println(client);
		return ResponseEntity.created(new URI(client.getId())).build();
	}
	
	@PostMapping("/issuer")
	public ResponseEntity createNewIssuer(@RequestBody Issuer issuer) throws URISyntaxException {
		System.out.println(issuer);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PostMapping("/order")
	public ResponseEntity createNewIssuer(@RequestBody Order order) throws URISyntaxException {
		System.out.println(order);
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
