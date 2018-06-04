package com.magierowski.SalesManager.domain.model;

import java.math.BigDecimal;

public class InvoiceSummary  {
	private BigDecimal taxTotal;
	private BigDecimal netTotal;
	private BigDecimal grossTotal;
	
	public InvoiceSummary(BigDecimal taxTotal, BigDecimal netTotal, BigDecimal grossTotal) {
		super();
		
		if(taxTotal.add(netTotal).compareTo(grossTotal) != 0) {
			throw new InternalError("Data consistency error: net and tax don't sum up to gross");
		}
		
		this.taxTotal = taxTotal;
		this.netTotal = netTotal;
		this.grossTotal = grossTotal;
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
}
