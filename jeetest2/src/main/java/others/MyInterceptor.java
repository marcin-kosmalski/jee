package others;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyInterceptorBinding
public class MyInterceptor implements Serializable {

	@AroundInvoke
	public Object auditMethodEntry(InvocationContext ctx) throws Exception {
		System.out.println("Before entering method:"
				+ ctx.getMethod().getName());
		return ctx.proceed();

	}

}
