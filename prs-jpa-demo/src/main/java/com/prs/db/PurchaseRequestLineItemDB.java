package com.prs.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.prs.business.PurchaseRequestLineItem;

public class PurchaseRequestLineItemDB {
	
	public static List<PurchaseRequestLineItem> getAll() {
		List<PurchaseRequestLineItem> purchaseRequestLineItem = null;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try {
			Query q = em.createQuery("Select b from PurchaseRequestLineItem b");
			purchaseRequestLineItem = q.getResultList();
		}
		finally {
			em.close();
		}
		return purchaseRequestLineItem;
		
	}
	public static boolean add(PurchaseRequestLineItem b) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(b);
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
