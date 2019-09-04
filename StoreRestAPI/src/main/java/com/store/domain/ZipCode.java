package com.store.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

@Entity
public class ZipCode 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ZipCode_ID")
	private long zipcodeID;
	
	@Column(name="Location", columnDefinition="Geometry", nullable = false)
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point location;
	
	@Column(name="ZipCode", nullable = false, unique=true)
	private String zipCode;
	
	@OneToMany(mappedBy="zipCode")
	private List<Store> stores = new ArrayList<Store>();

	public long getZipcodeID() {
		return zipcodeID;
	}

	public void setZipcodeID(long zipcodeID) {
		this.zipcodeID = zipcodeID;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "ZipCode [zipcodeID=" + zipcodeID + ", location=" + location
				+ ", zipCode=" + zipCode + ", stores=" + stores + "]";
	}
}
