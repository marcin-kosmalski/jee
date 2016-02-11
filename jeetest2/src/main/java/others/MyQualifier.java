package others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;




@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD }) 
@Retention(value=RetentionPolicy.RUNTIME)
@Qualifier 
public @interface MyQualifier {
	
	public enum Art{A1,A2};
	
	Art value();
	
	
}

