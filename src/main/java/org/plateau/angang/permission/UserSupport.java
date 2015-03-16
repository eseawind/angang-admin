package org.plateau.angang.permission;

/**
 * 供权限认证使用的人员信息获取接口，系统实现者只需要实现当前用户信息的获取功能
 * @see
 * {@link PermissionSupport}
 * 
 * @author quinn
 */
public interface UserSupport {
	
	String getCurrentUserId();

}
