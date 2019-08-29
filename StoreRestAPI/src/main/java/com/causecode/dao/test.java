package com.causecode.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.causecode.domain.ZipCode;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class test 
{
	
	public static void main(String args[]) throws ParseException
	{
		WKTReader fromText = new WKTReader();
		
		Point point1 = (Point) fromText.read("POINT(-66.749961 18.180555)");         
		Point point2 = (Point) fromText.read("POINT(-67.175597 18.361945)");
		Point point3 = (Point) fromText.read("POINT(-67.119887 18.455183)");
		
		ZipCode zipcode1 = new ZipCode();
		zipcode1.setZipCode("00601");
		zipcode1.setLocation(point1);
		
		ZipCode zipcode2 = new ZipCode();
		zipcode2.setZipCode("00602");
		zipcode2.setLocation(point2);
		
		ZipCode zipcode3 = new ZipCode();
		zipcode3.setZipCode("00603");
		zipcode3.setLocation(point3);
		

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(zipcode1);
		em.persist(zipcode2);
		em.persist(zipcode3);
		tx.commit();
		em.close();
	}
}
