package com.causecode.service;

import java.util.List;

import com.causecode.domain.ZipCode;
import com.causecode.dto.StoreDTO;
import com.causecode.dto.StoreDetailsDTO;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;

public interface StoreServiceable 
{
	void createStore(StoreDTO storeDto);
	Point getPointFromWKT(String storeLocation) throws ParseException;
	ZipCode getZipCode(String zipCode);
	void deleteStore(String licenceNumber);
	void updateStore(StoreDTO storeDto);
	List<StoreDetailsDTO> getStores(int miles, String zipCode);

}
