package com.store.dto;
import com.store.domain.ZipCode;
import com.vividsolutions.jts.geom.Point;

public class StoreDTO 
{
	private long storeID;
	
	private String storeName;
	
	private String licenceNumber;
	
	private String ownerName;
	
	private String storeType;
	
	private Point storeLocation;
	
	private ZipCode zipCode;
	
	private String state;
	
	private String country;
	
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


}
