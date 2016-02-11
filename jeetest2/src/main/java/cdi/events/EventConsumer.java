package cdi.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import others.Product;

@ApplicationScoped
public class EventConsumer {

	public void consumeProduct(@Observes Product product) {

		System.out.println("Consumed: " + product.getName());

	}

}
