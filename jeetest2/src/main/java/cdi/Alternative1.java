package cdi;

import javax.enterprise.inject.Alternative;



@Alternative
public class Alternative1 implements IMyAlternative {

	@Override
	public void test() {
		System.out.println("alternative 1");

	}

}
