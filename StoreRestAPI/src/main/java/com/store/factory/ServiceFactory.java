package com.store.factory;

import com.store.service.StoreService;
import com.store.service.StoreServiceable;

public class ServiceFactory 
{
	
	public static StoreServiceable getStoreService()
	{
		return new StoreService();
	}

}
