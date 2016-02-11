package cdi;

import javax.inject.Inject;

import others.MyQualifier;
import others.MyQualifier.Art;
import others.Product;

public class UserOfMyBean {

	@Inject
	private MyBean myBean;
	
	@Inject
	@MyQualifier(Art.A1)
	private Product product;
	
	@Inject
	@MyQualifier(Art.A2)
	private Product product2;

	public void test() {
		System.out.println("Mybean: " + myBean);
		myBean.printMessage();
	}
	
	public void testProducer(){
		System.out.println("Produced product name A1: "+product.getName());
		System.out.println("Produced product name A2: "+product2.getName());
	}
}
