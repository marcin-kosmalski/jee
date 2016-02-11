package cdi.transactions;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;

import entity.Unit;

public class TransactionsBean2 {

	@Inject
	private EntityManager entityManger;

	@Resource
	private UserTransaction userTransaction;

	public void doTransactions() {

		try {
			userTransaction.begin();

			entityManger.persist(new Unit("name1"));
			entityManger.persist(new Unit("name2"));
			entityManger.persist(new Unit("name3"));

			CriteriaQuery<Unit> c = entityManger.getCriteriaBuilder()
					.createQuery(Unit.class);
			c.select(c.from(Unit.class));
			System.out.println("unit list: "
					+ entityManger.createQuery(c).getResultList().size());

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

			CriteriaQuery<Unit> c = entityManger.getCriteriaBuilder()
					.createQuery(Unit.class);
			c.select(c.from(Unit.class));
			System.out.println("unit list again: "
					+ entityManger.createQuery(c).getResultList().size());

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
