package cdi.events;

import java.util.GregorianCalendar;

import javax.annotation.Resource;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import others.Product;

public class EventProducer {

	@Inject
	private Event<Product> eventProducer;
	
	

	public void createProduct() {

		Product product = Product.create("product"
				+ GregorianCalendar.getInstance().getTimeInMillis());

		System.out.println("Produced: " + product.getName());
		eventProducer.fire(product);
	}

}
