package com.magierowski.SalesManager.domain.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// przykład wzorca Immutable Object
// nie ma setterów, tylko konstruktor
public class Client {

	private String id;
	private String name;
	private String address;
	private String nip;

	@JsonCreator
	public Client(
			@JsonProperty("name") String name, 
			@JsonProperty("address") String address, 
			@JsonProperty("nip") String nip) {
		this.id = UUID.randomUUID().toString();
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
