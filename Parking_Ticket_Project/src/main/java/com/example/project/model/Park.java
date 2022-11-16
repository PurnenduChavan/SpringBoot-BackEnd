package com.example.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_list")
public class Park {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@Column(name="Vehiclename")
	private String vehiclenumber;
	
	@Column(name="Vehicletype")
	private String type;
	
	@Column(name="Intime")
	private long intime;
	
	@Column(name="outtime")
	private long outtime;
	
	public Park() {
		
	}

	
	
	
	
	
	public Park(String vehiclenumber, String type, long intime, long outtime) {
		super();
		this.vehiclenumber = vehiclenumber;
		this.type = type;
		this.intime = intime;
		this.outtime = outtime;
	}






	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getIntime() {
		return intime;
	}

	public void setIntime(long intime) {
		this.intime = intime;
	}

	public long getOuttime() {
		return outtime;
	}

	public void setOuttime(long outtime) {
		this.outtime = outtime;
	}
	
	
	
	

}
