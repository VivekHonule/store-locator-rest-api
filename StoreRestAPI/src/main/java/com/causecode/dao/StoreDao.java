package com.causecode.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.causecode.domain.Store;
import com.causecode.dto.StoreDTO;
import com.causecode.dto.StoreDetailsDTO;
import com.vividsolutions.jts.geom.Point;


public class StoreDao extends BaseDao implements StoreDataAccessible
{

	@Override
	public void createStore(StoreDTO storeDto) 
	{
		Store store = new Store();
		store.setCountry(storeDto.getCountry());
		store.setLicenceNumber(storeDto.getLicenceNumber());
		store.setOwnerName(storeDto.getOwnerName());
		store.setState(storeDto.getState());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		store.setStoreType(storeDto.getStoreType());
		store.setStreetAdd(storeDto.getStreetAdd());
		store.setZipCode(storeDto.getZipCode());
		
		save(store);
	}

	@Override
	public void deleteStore(String licenceNumber) 
	{
		EntityManager em = JPAUtils.createEntityManager();
		Query query = em.createQuery("from Store s where s.licenceNumber = :licenceNumber");
		query.setParameter("licenceNumber", licenceNumber);
		delete((Store)query.getSingleResult());
		em.close();
	}

	@Override
	public void updateStore(StoreDTO storeDto) 
	{
		Store store = new Store();
		store.setCountry(storeDto.getCountry());
		store.setLicenceNumber(storeDto.getLicenceNumber());
		store.setOwnerName(storeDto.getOwnerName());
		store.setState(storeDto.getState());
		store.setStoreID(storeDto.getStoreID());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		store.setStoreType(storeDto.getStoreType());
		store.setStreetAdd(storeDto.getStreetAdd());
		store.setZipCode(storeDto.getZipCode());
		
		update(store);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreDetailsDTO> getStores(int miles, Point zipCodeLocation) 
	{
		List<StoreDetailsDTO> stores = new ArrayList<StoreDetailsDTO>();
		
		String haversineQuery = "select s.store_name, s.store_type, y(s.store_location), x(s.store_location), z.zipcode, s.store_state, s.store_country, s.street_address, "
				+ "( 3959 * acos( cos( radians("+zipCodeLocation.getY()+") ) * cos( radians( y(store_location) ) ) * cos( radians( x(store_location) ) - radians("+
				zipCodeLocation.getX()+") ) + sin( radians("+zipCodeLocation.getY()+") ) * sin( radians( y(store_location) ) ) ) ) AS distance FROM "
				+ "store s inner join zipcode z on s.zipcode = z.zipcode_id having distance <"+miles;
		
		EntityManager em = JPAUtils.createEntityManager();
		Query query = em.createNativeQuery(haversineQuery);
		
		List<Object[]> store_details = query.getResultList();
		
		for(Object[] objects:store_details)
		{
			StoreDetailsDTO storeDetailsDto = new StoreDetailsDTO();
			
			storeDetailsDto.setStoreName(objects[0].toString());
			storeDetailsDto.setStoreType(objects[1].toString());
			storeDetailsDto.setLatitude(objects[2].toString());
			storeDetailsDto.setLongitude(objects[3].toString());
			storeDetailsDto.setZipCode(objects[4].toString());
			storeDetailsDto.setState(objects[5].toString());
			storeDetailsDto.setCountry(objects[6].toString());
			storeDetailsDto.setStreetAdd(objects[7].toString());
			
			stores.add(storeDetailsDto);
		}
		
		return stores;
	}
}
