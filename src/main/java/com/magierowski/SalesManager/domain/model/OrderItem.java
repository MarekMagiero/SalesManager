package com.magierowski.SalesManager.domain.model;

import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({ "name", "quantity", "netPrice", "taxRate", "taxValue", "grossValue", "netTotal", "taxTotal",
		"grossTotal" })
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private Integer quantity;
	private BigDecimal netPrice;
	private BigDecimal taxRate;

	// for Jackson only
	private OrderItem() {
	};

	public OrderItem(String name, Integer quantity, BigDecimal price, BigDecimal taxRate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.netPrice = price;
		this.taxRate = taxRate;
	}

	public String getName() {
		return name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getTaxValue() {
		return netPrice.multiply(taxRate);
	}

	public BigDecimal getGrossValue() {
		return netPrice.add(getTaxValue());
	}

	public BigDecimal getNetTotal() {
		return netPrice.multiply(valueOf(quantity));
	}

	public BigDecimal getTaxTotal() {
		return netPrice.multiply(taxRate).multiply(valueOf(quantity));
	}

	public BigDecimal getGrossTotal() {
		return getNetTotal().add(getTaxTotal());
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + ", netPrice=" + netPrice + ", taxRate=" + taxRate
				+ "]";
	}
}
