package com.prs.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.prs.business.Product;

public class ProductDB {
	
	public static List<Product> getAll() {
		List<Product> products = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			Query q = em.createQuery("Select p from Product p");
			products = q.getResultList();
		}
		finally {
			em.close();
		}
		return products;
		
	}
	public static boolean add(Product p) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(p);
			//em.flush();
			et.commit();
			success = true;
		}
		catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
		finally {
			em.close();
		}
		return success;
		
	}

}
