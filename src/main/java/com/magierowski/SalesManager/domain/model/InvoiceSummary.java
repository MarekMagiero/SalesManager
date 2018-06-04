package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceSummary {
	private BigDecimal taxTotal;
	private BigDecimal netTotal;
	private BigDecimal grossTotal;
	private LocalDate date;

	public InvoiceSummary(BigDecimal taxTotal, BigDecimal netTotal, BigDecimal grossTotal, LocalDate date) {
		super();

		if (taxTotal.add(netTotal).compareTo(grossTotal) != 0) {
			throw new InternalError("Data consistency error: net and tax don't sum up to gross");
		}

		this.taxTotal = taxTotal;
		this.netTotal = netTotal;
		this.grossTotal = grossTotal;
		this.date = date;
	}

	public BigDecimal getTaxTotal() {
		return taxTotal;
	}

	public BigDecimal getNetTotal() {
		return netTotal;
	}

	public BigDecimal getGrossTotal() {
		return grossTotal;
	}

	public LocalDate getDate() {
		return date;
	}

}
