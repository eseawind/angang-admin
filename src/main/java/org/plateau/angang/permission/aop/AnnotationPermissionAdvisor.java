package org.plateau.angang.permission.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.plateau.angang.permission.PermissionDeniedException;
import org.plateau.angang.permission.annotation.Permissible;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>统一的功能权限aop advisor，用于为每一个标注为{@link Permissible}的方法
 * 提供统一的功能权限检查。</p>
 * <p>权限横切逻辑在{@link PermissionAdvice}中实现。
 * @see
 * {@link Permissible}
 * {@link PermissionAdvice}
 * 
 * @author quinn
 */
@Component("permissionAdvisor")
public class AnnotationPermissionAdvisor extends AbstractPointcutAdvisor {

	private static final long serialVersionUID = 4029482593198347548L;
	
	@Autowired(required = false)
	private volatile PermissionAdvice advice;
	
	public void setAdvice(PermissionAdvice advice) {
		this.advice = advice;
	}
	
	/**
	 * {@link Permissible}注解标注的方法作为pointcut。
	 */
	private static class PointcutHolder {
		static final Pointcut pointcut = new AnnotationMatchingPointcut(null, Permissible.class);
	}
	
	/**
	 * 默认的权限拦截横切逻辑实现，用于spring容器未正常配置启动的时候。
	 */
	private static class AdviceHolder {
		
		static final Advice advice = new MethodInterceptor() {
			
			public Object invoke(MethodInvocation invocation) throws Throwable {
				throw new PermissionDeniedException();
			}
		};
	}

	public Pointcut getPointcut() {
		return PointcutHolder.pointcut;
	}

	public Advice getAdvice() {
		if (advice == null)
			return AdviceHolder.advice;
		return advice;
	}

}
