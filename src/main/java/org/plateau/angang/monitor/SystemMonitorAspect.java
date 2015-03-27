package org.plateau.angang.monitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemMonitorAspect {

	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}
	
	@Pointcut("within(org.plateau.angang..*)")
	private void inPackage() {}

	@Pointcut("anyPublicOperation() && inPackage()")
	public void tracePublicOperation() {}
	
}
