package cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class StdImplDecorator implements IMyInterface {

	@Inject
	@Delegate
	private IMyInterface stdImpl;
	
	@Override
	public void test() {
		System.out.println("my decorated std impl");
		
		stdImpl.test();

	}

}
