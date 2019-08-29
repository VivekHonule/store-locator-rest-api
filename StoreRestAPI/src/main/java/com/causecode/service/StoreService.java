package com.causecode.service;

import java.util.List;

import com.causecode.dao.StoreDataAccessible;
import com.causecode.dao.ZipCodeDataAccessible;
import com.causecode.domain.ZipCode;
import com.causecode.dto.StoreDTO;
import com.causecode.dto.StoreDetailsDTO;
import com.causecode.factory.DaoFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class StoreService implements StoreServiceable 
{

	@Override
	public void createStore(StoreDTO storeDto) 
	{
		StoreDataAccessible storeDao = DaoFactory.getStoreDao();
		storeDao.createStore(storeDto);
	}

	@Override
	public Point getPointFromWKT(String storeLocation) throws ParseException 
	{
		WKTReader fromText = new WKTReader();
		String wellKnownText = "POINT(" + storeLocation.substring(storeLocation.indexOf(',')+1, storeLocation.length()) + 
								" " + storeLocation.substring(0,storeLocation.indexOf(',')) + ")";
		Point point = (Point) fromText.read(wellKnownText);
		return point;
	}

	@Override
	public ZipCode getZipCode(String zipCode) 
	{
		ZipCodeDataAccessible zipCodeDao = DaoFactory.getZipCodeDao();
		return zipCodeDao.getZipCode(zipCode);
	}

	@Override
	public void deleteStore(String licenceNumber) 
	{
		StoreDataAccessible storeDao = DaoFactory.getStoreDao();
		storeDao.deleteStore(licenceNumber);
	}

	@Override
	public void updateStore(StoreDTO storeDto) 
	{
		StoreDataAccessible storeDao = DaoFactory.getStoreDao();
		storeDao.updateStore(storeDto);
	}

	@Override
	public List<StoreDetailsDTO> getStores(int miles, String zipCode) 
	{
		StoreDataAccessible storeDao = DaoFactory.getStoreDao();
		ZipCodeDataAccessible zipcodeDao = DaoFactory.getZipCodeDao();
		
		ZipCode zipCodeObj = zipcodeDao.getZipCode(zipCode);
		
		return storeDao.getStores(miles, zipCodeObj.getLocation());
	}

	
}
