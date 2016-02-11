package cdi.transactions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import entity.Unit;

@Transactional
public class CdiTransactionBean {

	@PersistenceContext
	private EntityManager entityManager;

	public void test() {
		entityManager.persist(new Unit("name1"));
		entityManager.persist(new Unit("name2"));
		entityManager.persist(new Unit("name3"));

		CriteriaQuery<Unit> c = entityManager.getCriteriaBuilder().createQuery(
				Unit.class);
		c.select(c.from(Unit.class));
		System.out.println("unit list: "
				+ entityManager.createQuery(c).getResultList().size());
	}

}
