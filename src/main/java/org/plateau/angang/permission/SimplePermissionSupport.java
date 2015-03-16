package org.plateau.angang.permission;

import org.plateau.angang.permission.annotation.Permissible;
import org.springframework.stereotype.Component;

/**
 * 权限验证逻辑注入示例。
 * @author quinn
 *
 */
@Component
public class SimplePermissionSupport implements PermissionSupport {

	public boolean permissible(Permissible permissible, String userId) {
		System.out.println("user[" + userId + "] has the permission of "
				+ permissible.value());
		return true;
	}

}
