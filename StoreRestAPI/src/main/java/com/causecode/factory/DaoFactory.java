package com.causecode.factory;

import com.causecode.dao.StoreDao;
import com.causecode.dao.StoreDataAccessible;
import com.causecode.dao.ZipCodeDao;
import com.causecode.dao.ZipCodeDataAccessible;

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
