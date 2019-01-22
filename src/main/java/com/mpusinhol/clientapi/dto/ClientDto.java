package com.mpusinhol.clientapi.dto;

import java.io.Serializable;
import java.util.Date;

import com.mpusinhol.clientapi.domain.Client;
import com.mpusinhol.clientapi.domain.Temperature;

public class ClientDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
	private Date createdAt;
	private Date updatedAt;
	private Temperature temperature;
	
	public ClientDto() {
		
	}
	
	public ClientDto(Client client) {
		id = client.getId();
		name = client.getName();
		age = client.getAge();
		createdAt = client.getCreatedAt();
		updatedAt = client.getUpdatedAt();
		temperature = client.getTemperature();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	
	public Client convertToClient() {
		return new Client(id, name, age, temperature, createdAt, updatedAt);
	}
}
