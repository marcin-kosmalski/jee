package service.cdi;

import javax.inject.Inject;

//@Named
public class CdiBean {

	@Inject
	@Configurable("k1")
	String message;
	
	@Inject
	String myMessage;
	
	@Inject
	@Configurable("k2")
	long numberValue;

	public String genMessage() {
		return "test: "+message+"/"+numberValue+"/"+myMessage;
	}
}
