package service.cdi;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

public class Configurator {
	
	@Produces
	public String getString(InjectionPoint ip) {
		
		Map<String,String> store=new HashMap<>();
		store.put("k1", "k2");
		store.put("k2", "78");
		store.put("myMessage", "itworks!");
		
		
	//	String className = ip.getMember().getDeclaringClass().getName();
		//String key = className + "." + ip.getMember().getName();
		String key=ip.getMember().getName();
		String fieldName = computeKeyName(ip.getAnnotated(), key);
		return store.get(fieldName);
	}

	String computeKeyName(Annotated annotated, String key) {
		Configurable annotation = annotated.getAnnotation(Configurable.class);
		System.out.println(key);
		return annotation == null ? key : annotation.value();
	}

	@Produces
	public long getLong(InjectionPoint ip) {
		String stringValue = getString(ip);
		if (stringValue == null) {
			return 0;
		}
		return Long.parseLong(stringValue);
	}
}
