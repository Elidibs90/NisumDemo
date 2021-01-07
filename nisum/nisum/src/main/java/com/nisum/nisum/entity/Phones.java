package com.nisum.nisum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Phones")
public class Phones {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="number")
    private String number;
    
    @Column(name="cityCode")
    private String cityCode;
    
    @Column(name="countryCode")
    private String countryCode;
    
    public Phones() {}

    public Phones(int id, String number, String cityCode, String countryCode) {
        this.id = id;
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Phones [id=" + id + ", number=" + number + ", cityCode=" + cityCode + ", countryCode=" + countryCode
				+ "]";
	}
    
    
    
}
