package br.com.caelum.livraria.common;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptor {
	
	@AroundInvoke
	public Object interceptor(InvocationContext context) throws Exception {
		Object proceed = context.proceed();
		long currentTimeMillis = System.currentTimeMillis();
		String method = context.getMethod().getName();
		String className = context.getTarget().getClass().getSimpleName();
		System.out.println("Time usage at " + method + " into " + className
				+ ": " + (System.currentTimeMillis() - currentTimeMillis));
		return proceed;
		
	}

}
