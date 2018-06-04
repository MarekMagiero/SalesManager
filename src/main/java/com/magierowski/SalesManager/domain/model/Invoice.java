package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
	private Order order;
	private Client client;
	private Issuer issuer;
	private LocalDate date;

	public Invoice(Order order, Client client, Issuer issuer, LocalDate date) {
		super();
		this.order = order;
		this.client = client;
		this.issuer = issuer;
		this.date = date;
	}

	public Order getOrder() {
		return order;
	}

	public Client getClient() {
		return client;
	}

	public Issuer getIssuer() {
		return issuer;
	}

	public LocalDate getDate() {
		return date;
	}

	public InvoiceSummary getSummary() {
		BigDecimal taxTotal = order.getTaxTotal();
		BigDecimal netTotal = order.getNetTotal();
		BigDecimal grossTotal = taxTotal.add(netTotal);
		
		return new InvoiceSummary(netTotal, taxTotal, grossTotal, date);
	}

	@Override
	public String toString() {
		return "Invoice [\n    order=" + order + ", \n    client=" + client + ", \n    issuer=" + issuer + "\n]";
	}
}
