package com.causecode.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

@Entity
public class Store 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Store_ID")
	private long storeID;
	
	@Column(name="Store_Name", nullable = false)
	private String storeName;
	
	@Column(name="Licence_Number", nullable = false, unique = true)
	private String licenceNumber;
	
	@Column(name="Store_Owner")
	private String ownerName;
	
	@Column(name="Store_Type", nullable = false)
	private String storeType;
	
	@Column(name="Store_Location", nullable = false)
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point storeLocation;
	
	@ManyToOne
	@JoinColumn(name="ZipCode")
	private ZipCode zipCode;
	
	@Column(name="Store_State", nullable = false)
	private String state;
	
	@Column(name="Store_Country", nullable = false)
	private String country;
	
	@Column(name="Street_Address", nullable = false)
	private String streetAdd;

	public long getStoreID() {
		return storeID;
	}

	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public Point getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(Point storeLocation) {
		this.storeLocation = storeLocation;
	}

	public ZipCode getZipCode() {
		return zipCode;
	}

	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetAdd() {
		return streetAdd;
	}

	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}

	@Override
	public String toString() {
		return "Store [storeID=" + storeID + ", storeName=" + storeName
				+ ", licenceNumber=" + licenceNumber + ", ownerName="
				+ ownerName + ", storeTye=" + storeType + ", storeLocation="
				+ storeLocation + ", zipCode=" + zipCode + ", state=" + state
				+ ", country=" + country + ", streetAdd=" + streetAdd + "]";
	}
}
