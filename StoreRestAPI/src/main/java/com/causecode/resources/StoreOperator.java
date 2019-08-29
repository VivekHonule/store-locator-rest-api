package com.causecode.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.causecode.dto.StoreDTO;
import com.causecode.dto.StoreDetailsDTO;
import com.causecode.factory.ServiceFactory;
import com.causecode.service.StoreServiceable;
import com.vividsolutions.jts.io.ParseException;


@Path("/store")
public class StoreOperator 
{
		@GET
		@Path("create")
		public Response createStore(
				@QueryParam("storeName") String storeName,
				@QueryParam("licenceNumber") String licenceNumber,
				@QueryParam("ownerName") String ownerName,
				@QueryParam("storeType") String storeType,
				@QueryParam("storeLocation") String storeLocation,
				@QueryParam("zipCode") String zipCode,
				@QueryParam("state") String state,
				@QueryParam("country") String country,
				@QueryParam("streetAdd") String streetAdd) throws ParseException
				
		{
			try
			{
				StoreServiceable storeServiceable = ServiceFactory.getStoreService();
			
				StoreDTO storeDto = new StoreDTO();
				storeDto.setStoreName(storeName.trim());
				storeDto.setLicenceNumber(licenceNumber.trim());
				storeDto.setOwnerName(ownerName.trim());
				storeDto.setStoreType(storeType.trim());
				storeDto.setStoreLocation(storeServiceable.getPointFromWKT(storeLocation.trim()));
				storeDto.setZipCode(storeServiceable.getZipCode(zipCode.trim()));
				storeDto.setState(state.trim());
				storeDto.setCountry(country.trim());
				storeDto.setStreetAdd(streetAdd.trim());
				
				storeServiceable.createStore(storeDto);
				
				return Response.status(200).entity("SUCCESS").build();
			}
			catch(Exception e)
			{
				return Response.status(400).entity("Error Occured:   "+e.toString()).build();
			}
			
		}
		
		
		@GET
		@Path("delete")
		public Response deleteStore(@QueryParam("licenceNumber") String licenceNumber)
		{
			try
			{
				StoreServiceable storeService = ServiceFactory.getStoreService();
				storeService.deleteStore(licenceNumber.trim());
				
				return Response.status(200).entity("SUCCESS").build();
			}
			catch(Exception e)
			{
				return Response.status(400).entity("Error Occured:    "+e.toString()).build();				
			}
		}
		
		@GET
		@Path("update")
		public Response updateStore(
				@QueryParam("storeID") long storeID,
				@QueryParam("storeName") String storeName,
				@QueryParam("licenceNumber") String licenceNumber,
				@QueryParam("ownerName") String ownerName,
				@QueryParam("storeType") String storeType,
				@QueryParam("storeLocation") String storeLocation,
				@QueryParam("zipCode") String zipCode,
				@QueryParam("state") String state,
				@QueryParam("country") String country,
				@QueryParam("streetAdd") String streetAdd)
		{
			try
			{
				StoreServiceable storeService = ServiceFactory.getStoreService();
				
				StoreDTO storeDto = new StoreDTO();
				storeDto.setCountry(country.trim());
				storeDto.setLicenceNumber(licenceNumber.trim());
				storeDto.setOwnerName(ownerName.trim());
				storeDto.setState(state.trim());
				storeDto.setStoreID(storeID);
				storeDto.setStoreLocation(storeService.getPointFromWKT(storeLocation));
				storeDto.setStoreName(storeName);
				storeDto.setStoreType(storeType);
				storeDto.setStreetAdd(streetAdd);
				storeDto.setZipCode(storeService.getZipCode(zipCode.trim()));
				
				storeService.updateStore(storeDto);
				
				return Response.status(200).entity("SUCCESS").build();
			}
			catch(Exception e)
			{
				return Response.status(400).entity("Error Occured :"+e.toString()).build();
			}
			
		}
		
		@GET
		@Path("get")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getStoresWithinMilesOfZipCode(
				@QueryParam("miles") int miles,
				@QueryParam("zipcode") String zipCode)
		{
			try
			{
				StoreServiceable storeService  = ServiceFactory.getStoreService();
				List<StoreDetailsDTO> stores = storeService.getStores(miles, zipCode);
				
				return Response.ok(stores).build();
			}
			catch(Exception e)
			{
				return Response.status(400).entity("Message:"+"Bad Request").build();
			}
			
		}
				
}
