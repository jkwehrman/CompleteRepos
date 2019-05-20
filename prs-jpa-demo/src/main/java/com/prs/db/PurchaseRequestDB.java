package com.prs.db;

	import java.util.ArrayList;
	import java.util.List;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Query;

	import com.prs.business.PurchaseRequest;

	public class PurchaseRequestDB {
		
		public static List<PurchaseRequest> getAll() {
			List<PurchaseRequest> purchaseRequest = null;
			
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			
			try {
				Query q = em.createQuery("Select a from PurchaseRequest a");
				purchaseRequest = q.getResultList();
			}
			finally {
				em.close();
			}
			return purchaseRequest;
		}
		public static boolean add(PurchaseRequest a) {
			boolean success = false;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			try {
				et.begin();
				em.persist(a);
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

