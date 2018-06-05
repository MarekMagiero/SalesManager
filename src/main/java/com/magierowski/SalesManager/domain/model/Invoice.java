package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@OneToOne
	private Order order;
	@OneToOne
	private Client client;
	@OneToOne
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

	public String getId() {
		return id;
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
