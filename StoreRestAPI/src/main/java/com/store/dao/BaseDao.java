package com.store.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class BaseDao 
{
	public void save(Object cls)
	{
		EntityManager em = JPAUtils.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(cls);
		tx.commit();
		em.close();
	}
	
	public void delete(Object cls)
	{
		EntityManager em = JPAUtils.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(cls) ? cls : em.merge(cls));
		tx.commit();
		em.close();
	}
	
	public void update(Object cls)
	{
		EntityManager em = JPAUtils.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(cls);
		tx.commit();
		em.close();
	}
	
	

}
