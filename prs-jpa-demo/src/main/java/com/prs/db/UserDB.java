//corrected from Sean's code

package com.prs.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.prs.business.User;

public class UserDB {

	public static List<User> getAll() {
		List<User> users = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Query q = em.createQuery("Select u from User u");
			users = q.getResultList();
		}
		finally {
			em.close();
		}
		return users;
	}


	
	public static boolean add(User u) {
		boolean success = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		// =====================================================
		try {
			et.begin();
			em.persist(u);
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
