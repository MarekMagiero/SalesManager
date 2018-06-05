package com.magierowski.SalesManager.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Issuer {

	@Id
	@NotNull
	private String nip;
	
	private String name;
	private String address;
	private String zipCode;
	private String city;
	private String bankName;
	private String bankAccount;

	// for Jackson only
	private Issuer() {
	};

	public Issuer(String name, String address, String zipCode, String city, String nip, String bankName,
			String bankAccount) {
		super();
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.nip = nip;
		this.bankName = bankName;
		this.bankAccount = bankAccount;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getNip() {
		return nip;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	@Override
	public String toString() {
		return "Issuer [name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", nip="
				+ nip + ", bankName=" + bankName + ", bankAccount=" + bankAccount + "]";
	}
}
