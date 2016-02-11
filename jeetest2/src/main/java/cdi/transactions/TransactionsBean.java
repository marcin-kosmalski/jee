package cdi.transactions;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;

import entity.Unit;

public class TransactionsBean {

	@PersistenceUnit(unitName = "MyPU")
	private EntityManagerFactory entityManagerFactory;

	@Resource
	private UserTransaction userTransaction;

	public void doTransactions() {

		try {
			userTransaction.begin();

			EntityManager em = entityManagerFactory.createEntityManager();

			em.persist(new Unit("name1"));
			em.persist(new Unit("name2"));
			em.persist(new Unit("name3"));

			CriteriaQuery<Unit> c = em.getCriteriaBuilder().createQuery(
					Unit.class);
			c.select(c.from(Unit.class));
			System.out.println("unit list: "
					+ em.createQuery(c).getResultList().size());

			userTransaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();

			try {
				userTransaction.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void doRead() {

		try {
			userTransaction.begin();

			EntityManager em = entityManagerFactory.createEntityManager();

			CriteriaQuery<Unit> c = em.getCriteriaBuilder().createQuery(
					Unit.class);
			c.select(c.from(Unit.class));
			System.out.println("unit list again: "
					+ em.createQuery(c).getResultList().size());

			userTransaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();

			try {
				userTransaction.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
