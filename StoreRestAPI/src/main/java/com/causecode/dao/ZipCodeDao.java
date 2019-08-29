package com.causecode.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.causecode.domain.ZipCode;

public class ZipCodeDao extends BaseDao implements ZipCodeDataAccessible
{
	@Override
	public ZipCode getZipCode(String zipCode)
	{
		EntityManager entityManager = JPAUtils.createEntityManager();
		Query query = entityManager.createQuery("from ZipCode z where z.zipCode = :zipCode ");
		query.setParameter("zipCode", zipCode);
		ZipCode zipCodeObj = (ZipCode) query.getSingleResult();
		entityManager.close();
		return zipCodeObj;
	}
}
