package com.causecode.factory;

import com.causecode.service.StoreService;
import com.causecode.service.StoreServiceable;

public class ServiceFactory 
{
	
	public static StoreServiceable getStoreService()
	{
		return new StoreService();
	}

}
