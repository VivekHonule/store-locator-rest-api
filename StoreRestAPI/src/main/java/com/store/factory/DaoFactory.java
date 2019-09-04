package com.store.factory;

import com.store.dao.StoreDao;
import com.store.dao.StoreDataAccessible;
import com.store.dao.ZipCodeDao;
import com.store.dao.ZipCodeDataAccessible;

public class DaoFactory 
{
	
	public static StoreDataAccessible getStoreDao()
	{
		return new StoreDao();
	}
	
	public static ZipCodeDataAccessible getZipCodeDao()
	{
		return new ZipCodeDao();
	}

}
