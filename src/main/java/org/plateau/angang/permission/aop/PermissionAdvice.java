package org.plateau.angang.permission.aop;

import java.lang.annotation.Annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.plateau.angang.permission.PermissionDeniedException;
import org.plateau.angang.permission.PermissionSupport;
import org.plateau.angang.permission.UserSupport;
import org.plateau.angang.permission.annotation.Permissible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通用权限检查横切逻辑（advice）。
 * 将权限横切逻辑使用模版方法模式拆分，应用程序实现者只需关注两点即可<p>
 * <li>用户信息的获取，即实现{@link UserSupport}接口；</li>
 * <li>权限的验证，即实现{@link PermissionSupport}接口。</li>
 * </p>
 * @see {@link UserSupport}
 * {@link PermissionSupport}
 * {@link PermissionDeniedException}
 * 
 * @author quinn
 */
@Component
class PermissionAdvice implements MethodInterceptor {

	@Autowired
	private PermissionSupport permissionSupport;
	
	@Autowired
	private UserSupport userSupport;

	public void setPermissionSupport(PermissionSupport permissionSupport) {
		this.permissionSupport = permissionSupport;
	}

	public Object invoke(final MethodInvocation methodInvocation)
			throws Throwable {
		Permissible permissible = methodInvocation.getMethod().getAnnotation(
				Permissible.class);
		if (permissible == null)// never happen!
			throw new RuntimeException("Method[" + methodInvocation.getMethod()
					+ "] dosn't have the annotation of Permissible");
		if (permissible.value() == null
				|| permissible.value().trim().length() == 0) {
			permissible = new Permissible() {

				public Class<? extends Annotation> annotationType() {
					return Permissible.class;
				}

				public String value() {
					return methodInvocation.getMethod().getName();
				}
			};
		}
		if (!permissionSupport.permissible(permissible, userSupport.getCurrentUserId())) {
			// TODO logger
			throw new PermissionDeniedException("");
		}
		return methodInvocation.proceed();
	}

}