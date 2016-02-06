package service;

import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import dao.UnitDAOImpl;
import entity.Unit;

@Singleton
public class MySingleton {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private UnitDAOImpl unitDao;


	public void op1() {

		
		Unit unit=Unit.create("name1", "type1");
		
		em.persist(unit);
		
		unit.setType("mmm");
		
		System.out.println("op1: "+this);
	}
	
	public void list(){
		unitDao.findAll().stream().forEach(unit->System.out.println(unit));	
	}
	
	public void update(Unit unit,long id){
		
		unit.setType("newType");
		
		System.out.println(em.find(Unit.class, id).getType());
		
	}

}
