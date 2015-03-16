package org.plateau.angang.permission.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.plateau.angang.permission.PermissionSupport;
import org.plateau.angang.permission.UserSupport;

/**
 * <p>此注解用来供开发者标注相关功能权限，只能作用于方法，且方法所在的bean必须是被spring容器所管理的。
 * 如果某个功能方法需要权限验证，那么则需要对其添加此注解。value的值应为该功能的id。若没有提供value值，
 * 系统默认使用方法名作为功能id</p>
 * <p>系统开发者只需在其需要验证权限的方法前添加此注解（注明功能id），并实现{@link UserSupport}和
 * {@link PermissionSupport}两个接口就可以实现权限检查的织入。</p>
 * @see
 * {@link UserSupport}
 * {@link PermissionSupport}
 * 
 * @author quinn
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Permissible {

	String value() default "";

}
