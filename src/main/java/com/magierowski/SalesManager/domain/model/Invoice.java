package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;

public class Invoice {
	private Order order;
	private Client client;
	private Issuer issuer;

	public Invoice(Order order, Client client, Issuer issuer) {
		super();
		this.order = order;
		this.client = client;
		this.issuer = issuer;
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

	public InvoiceSummary getSummary() {
		BigDecimal taxTotal = order.getTaxTotal();
		BigDecimal netTotal = order.getNetTotal();
		BigDecimal grossTotal = taxTotal.add(netTotal);

		return new InvoiceSummary(netTotal, taxTotal, grossTotal);
	}

	@Override
	public String toString() {
		return "Invoice [\n    order=" + order + ", \n    client=" + client + ", \n    issuer=" + issuer + "\n]";
	}
}
