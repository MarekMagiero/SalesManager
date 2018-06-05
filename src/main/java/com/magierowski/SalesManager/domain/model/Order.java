package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@OneToOne
	private Client client;

	@OneToMany
	private List<OrderItem> items = new ArrayList();

	// for Jackson only
	private Order() {
	};

	public Order(Client client, List<OrderItem> items) {
		super();
		this.client = client;
		this.items = items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Integer getId() {
		return id;
	}

	@JsonIgnore
	public BigDecimal getNetTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (OrderItem item : items) {
			total = total.add(item.getNetTotal());
		}

		return total;
	}

	@JsonIgnore
	public BigDecimal getTaxTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (OrderItem item : items) {
			total = total.add(item.getTaxTotal());
		}

		return total;
	}
}
