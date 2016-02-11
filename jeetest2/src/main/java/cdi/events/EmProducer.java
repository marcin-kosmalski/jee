package cdi.events;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class EmProducer {

	@PersistenceUnit(unitName = "MyPU")
	private EntityManagerFactory entityManagerFactory;

	@Produces
	public EntityManager produceEntityManager() {
		System.out.println("em produced");

		return entityManagerFactory.createEntityManager();
	}
}
