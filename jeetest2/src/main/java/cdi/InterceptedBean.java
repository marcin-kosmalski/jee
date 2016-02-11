package cdi;

import javax.annotation.PostConstruct;

import others.MyInterceptorBinding;

@MyInterceptorBinding
public class InterceptedBean {

	
	@PostConstruct
	public void init(){
		System.out.println("init method");
	}
	
	public void test() {
		System.out.println("test");
	}
}
