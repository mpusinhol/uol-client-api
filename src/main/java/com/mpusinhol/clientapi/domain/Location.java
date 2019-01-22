package com.mpusinhol.clientapi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String continent;
	private String country;
	private String subdivisionOne;
	private String subdivisionTwo;
	private String city;
	private Double latitude;
	private Double longitude;
	private Date createdAt;
	
	public Location() {
		
	}

	public Location(Long id, String continent, String country, String subdivisionOne, String subdivisionTwo,
			String city, Double latitude, Double longitude, Date createdAt) {
		this.id = id;
		this.continent = continent;
		this.country = country;
		this.subdivisionOne = subdivisionOne;
		this.subdivisionTwo = subdivisionTwo;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubdivisionOne() {
		return subdivisionOne;
	}

	public void setSubdivisionOne(String subdivisionOne) {
		this.subdivisionOne = subdivisionOne;
	}

	public String getSubdivisionTwo() {
		return subdivisionTwo;
	}

	public void setSubdivisionTwo(String subdivisionTwo) {
		this.subdivisionTwo = subdivisionTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@PrePersist
	private void setCreatedAt() {
		createdAt = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
