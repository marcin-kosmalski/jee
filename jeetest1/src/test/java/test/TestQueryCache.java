package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import entity.CachedUnit;
import entity.Owner;

@RunWith(Arquillian.class)
public class TestQueryCache {

	@PersistenceContext
	private EntityManager em;

	@PersistenceUnit(unitName = "MyPU")
	private EntityManagerFactory entityMangerFactory;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addPackage(CachedUnit.class.getPackage())
				.addAsManifestResource("META-INF/persistence.xml",
						"persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	@InSequence(1)
	@UsingDataSet("data/default.yml")
	@Cleanup(phase = TestExecutionPhase.BEFORE, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testFirstLevelCache() {

		System.out.println("1.1: " + em.find(Owner.class, 1l).getName());
		System.out.println("1.1: "+em.find(Owner.class, 1l).getCachedUnitList().size());
	}
	
	@Test
	@InSequence(2)
	@UsingDataSet("data/default.yml")
	@Cleanup(phase = TestExecutionPhase.BEFORE, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testSecondLevelCacheOwnerUnit1() {
		
		CachedUnit cachedUnit=em.find(CachedUnit.class, 1l);
		
		System.out.println("2.1: "+em.createQuery("from CachedUnit").getResultList().size());

		System.out.println("2.2: " + cachedUnit.getName());
	}


	@Test
	@InSequence(3)
	@UsingDataSet("data/default.yml")
	@Cleanup(phase = TestExecutionPhase.BEFORE, strategy = CleanupStrategy.USED_TABLES_ONLY)
	public void testSecondLevelCacheOwnerUnit2() {
		
		Owner owner=em.find(Owner.class, 1l);

		System.out.println("3.1: " + owner.getName());
		
		System.out.println("3.2: "+owner.getCachedUnitList().size());
		
		System.out.println("3.3: "+em.createQuery("from CachedUnit").getResultList().size());
	}

//	@Test
//	@InSequence(3)
//	@UsingDataSet("data/default.yml")
//	@Cleanup(phase = TestExecutionPhase.BEFORE, strategy = CleanupStrategy.USED_TABLES_ONLY)
//	public void testSecondLevelCacheOwnerUnit2() {
//		
//		Owner owner=em.find(Owner.class, 1l);
//
//		System.out.println("2.1: " + owner.getName());
//		
//		System.out.println("2.1: "+owner.getCachedUnitList().size());
//	}
//	
//	@Test
//	@InSequence(2)
//	@UsingDataSet("data/default.yml")
//	@Cleanup(phase = TestExecutionPhase.BEFORE, strategy = CleanupStrategy.USED_TABLES_ONLY)
//	public void testSecondLevelCacheOwnerUnit3() {
//		
//		CachedUnit cachedUnit=em.find(CachedUnit.class, 1l);
//
//		System.out.println("3.1: " + cachedUnit.getName());
//		
//		System.out.println("3.1: "+cachedUnit.getReferenceEntity().getName());
//	}
//	
//	@Test
//	@InSequence(2)
//	@UsingDataSet("data/default.yml")
//	@Cleanup(phase = TestExecutionPhase.BEFORE, strategy = CleanupStrategy.USED_TABLES_ONLY)
//	public void testSecondLevelCacheOwnerUnit4() {
//		
//		CachedUnit cachedUnit=em.find(CachedUnit.class, 1l);
//
//		System.out.println("4.1: " + cachedUnit.getName());
//		
//		System.out.println("4.1: "+cachedUnit.getReferenceEntity().getName());
//	}
//	
	

}
