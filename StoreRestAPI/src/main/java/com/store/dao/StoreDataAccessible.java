package com.store.dao;

import java.util.List;

import com.store.dto.StoreDTO;
import com.store.dto.StoreDetailsDTO;
import com.vividsolutions.jts.geom.Point;

public interface StoreDataAccessible 
{
	void createStore(StoreDTO storeDto);
	void deleteStore(String licenceNumber);
	void updateStore(StoreDTO storeDto);
	List<StoreDetailsDTO> getStores(int miles, Point zipCodeLocation);
	

}
