package com.magierowski.SalesManager.domain.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// przykład wzorca Immutable Object
// nie ma setterów, tylko konstruktor
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String address;
	private String nip;

	@JsonCreator
	public Client(
			@JsonProperty("name") String name, 
			@JsonProperty("address") String address, 
			@JsonProperty("nip") String nip) {
		this.name = name;
		this.address = address;
		this.nip = nip;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getNip() {
		return nip;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", address=" + address + ", nip=" + nip + "]";
	}

}
