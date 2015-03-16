package org.plateau.angang.permission.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 为功能权限横切逻辑（{@link AnnotationPermissionAdvisor}）提供支持，
 * 使spring容器启动时可以扫描并注册此横切逻辑。
 * @see
 *{@link AnnotationPermissionAdvisor}
 *
 * @author quinn
 */
@Component
public class AnnotationPermissionPostProccessor implements
		BeanFactoryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("permissionAdvisor");
		if (beanDefinition != null && beanDefinition instanceof AbstractBeanDefinition) {
			/*
			 * 设置AnnotationPermissionAdvisor bean描述的角色为spring系统级别，与客户端程序无关（将权限与客户端代码分离）
			 * 或可考虑单独配置permission相关组建。此处选用简单方式。
			 */
			((AbstractBeanDefinition)beanDefinition).setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		}
	}

}
