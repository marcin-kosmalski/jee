package cdi;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import others.MyQualifier;
import others.MyQualifier.Art;
import others.Product;

public class MyProducer {

	@Produces
	@MyQualifier(Art.A1)
	public Product createProduct1() {
		return Product.create("created using qualifier A1");
	}
	
	@Produces
	@MyQualifier(Art.A2)
	public Product createProduct2() {
		return Product.create("created using qualifier A2");
	}

	public void disposeWord(@Disposes @Any Product product) {
		System.out.println(" Before closing I tell you the secret word was "
				+ product.getName());
	}

}
