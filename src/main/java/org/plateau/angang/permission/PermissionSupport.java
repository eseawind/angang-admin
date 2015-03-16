package org.plateau.angang.permission;

import org.plateau.angang.permission.annotation.Permissible;

/**
 * 功能权限验证接口，系统实现者只需要实现权限认证，不需关心权限验证的织入过程。
 * @see
 * {@link UserSupport}
 * 
 * @author quinn
 */
public interface PermissionSupport {
	
	boolean permissible(Permissible permissible, String userId);

}
