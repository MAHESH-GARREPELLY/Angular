package com.mahesh.angularjs.model;

import java.io.Serializable;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT")
@PrimaryKeyJoinColumn(name= "ID")


public class Contact implements Serializable {
	
	
	@Id
    @SequenceGenerator(name = "CONTACT_ID_GEN", sequenceName = "CONTACT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_ID_GEN")
    
	@Column(name = "ID", nullable = false)
    private Integer id;
    
	@Column(name= "FIRSTNAME")
    private String firstname;
    
	@Column (name= "MIDDLENAME")
    private String middlename;
   
	@Column(name = "LASTNAME")
    private String lastname;
    
	@Column(name = "GENDER")
    private String gender;
    
	@Column(name = "EMAIL")
    private String email;
    
	@Column(name = "PHONE")
    private String phone;
    
	@Column(name = "ADDRESS")
    private String address;
    
	@Column(name = "CITY")
    private String city;
    
    @Column(name = "PINCODE")
    private int pincode;
	
    @Column(name = "PROFILE")
    private byte[] profile;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public byte[] getProfile() {
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}




}
