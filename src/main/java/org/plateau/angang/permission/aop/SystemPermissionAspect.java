package org.plateau.angang.permission.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemPermissionAspect {
	
	@Pointcut("within(org.plateau..*.controllers.*)")
	private void allControllers() {};
	
	@Pointcut("@annotation(org.plateau.angang.permission.annotation.Permissible)")
	private void permissibleAnnotation() {};
	
	@Pointcut("allControllers() && permissibleAnnotation()")
	public void permissionPointcut() {}

}
