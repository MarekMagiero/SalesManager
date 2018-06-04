package com.magierowski.SalesManager.domain.service;


import java.math.BigDecimal;
import java.util.List;

import com.magierowski.SalesManager.domain.model.*;

public class InvoiceGenerator {
	public Invoice invoice(Order order, Client client, Issuer dealer) {
		Invoice invoice = new Invoice(order, client, dealer);
		
		return invoice;
	}
}