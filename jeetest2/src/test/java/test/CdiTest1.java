package test;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import others.Product;
import cdi.AlternativeConsumer;
import cdi.IMyInterface;
import cdi.InterceptedBean;
import cdi.UserOfMyBean;
import cdi.events.EventConsumer;
import cdi.events.EventProducer;
import cdi.transactions.CdiTransactionBean;
import cdi.transactions.TransactionsBean;
import cdi.transactions.TransactionsBean2;
import entity.Unit;

@RunWith(Arquillian.class)
public class CdiTest1 {

	@Inject
	private UserOfMyBean userOfMyBean;

	@Inject
	private InterceptedBean interceptedBean;

	@Inject
	private IMyInterface stdImplDecorator;

	@Inject
	private IMyInterface stdImpl;

	@Inject
	private AlternativeConsumer alternativeConsumer;

	@Inject
	private EventProducer eventProducer;

	@Inject
	private TransactionsBean transationsBean;

	@Inject
	private TransactionsBean2 transationsBean2;
	
	@Inject
	private CdiTransactionBean cdiTransactoinBean;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class)
				.addPackage(UserOfMyBean.class.getPackage())
				.addPackage(Product.class.getPackage())
				.addPackage(EventConsumer.class.getPackage())
				.addPackage(Unit.class.getPackage())
				.addPackage(TransactionsBean2.class.getPackage())
				.addAsManifestResource("META-INF/beans.xml", "beans.xml")
				.addAsManifestResource("META-INF/persistence.xml",
						"persistence.xml");
		// .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	

	@Test
	public void newTransactionAnnotationTest(){
		
		cdiTransactoinBean.test();
	}
	
	@Test
	@InSequence(1)
	@Ignore
	public void transactionsInCdiTest1() {

		// transationsBean.doTransactions();

		transationsBean2.doTransactions();
	}

	@Test
	@InSequence(2)
	@Ignore
	public void transactionsInCdiTest2() {

		// transationsBean.doRead();
		transationsBean2.doRead();
	}

	@Test
	@Ignore
	public void eventsTest() {

		eventProducer.createProduct();

	}

	@Test
	@Ignore
	public void alternativeTest() {

		alternativeConsumer.callMe();

	}

	@Test
	@Ignore
	public void decoratorTest() {
		stdImplDecorator.test();

		stdImpl.test();
	}

	@Test
	@Ignore
	public void testInterceptor() {
		interceptedBean.test();
	}

	@Test
	@Ignore
	public void testDependentScope() {
		userOfMyBean.test();
		userOfMyBean.test();
	}

	@Test
	@Ignore
	public void testDependentScope2() {
		userOfMyBean.test();
		userOfMyBean.test();
	}

	@Test
	@Ignore
	public void testProducer() {
		userOfMyBean.testProducer();
	}

}
