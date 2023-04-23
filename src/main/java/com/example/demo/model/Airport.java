package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

	@Id
    @Column(name = "airport_name")
    private String airport_name;

    @Column(name = "city")
    private String city;

	@Column(name = "state")
    private String state;

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    public Airport(String airport_name, String city, String state) {
		super();
		this.airport_name = airport_name;
		this.city = city;
		this.state = state;
	}

//	public long getId() {
//		return id;
//	}

//	public void setId(long id) {
//		this.id = id;
//	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    
}