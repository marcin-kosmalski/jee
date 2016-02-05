package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Unit;

@Stateless
public class UnitDAOImpl {

	@PersistenceContext
	private EntityManager em;

	public Unit get(long id) {
		return em.find(Unit.class, id);
	}

	public void save(Unit unit) {
		em.merge(unit);
	}

	public List<Unit> findAll() {

		CriteriaQuery<Unit> c = em.getCriteriaBuilder().createQuery(Unit.class);
		c.select(c.from(Unit.class));
		return em.createQuery(c).getResultList();
	}

}
