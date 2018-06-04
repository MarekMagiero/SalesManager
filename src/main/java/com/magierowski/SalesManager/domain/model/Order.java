package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {

	private String clientId;
	private List<OrderItem> items = new ArrayList();
	
	// for Jackson only
	private Order() {};
	
	public Order(String clientId) {
		this.clientId = clientId;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public String getClientId() {
		return clientId;
	}
	
	@JsonIgnore
	public BigDecimal getNetTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(OrderItem item : items) {
			total = total.add(item.getNetTotal());
		}
		
		return total;
	}

	@JsonIgnore
	public BigDecimal getTaxTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(OrderItem item : items) {
			total = total.add(item.getTaxTotal());
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		return "Order [clientId=" + clientId + ", items=" + items + "]";
	}


}
