package org.plateau.angang.permission;

import org.springframework.stereotype.Component;

/**
 * 为权限注入用户信息示例。
 * @author quinn
 *
 */

@Component
public class SimpleUserSupport implements UserSupport {

	public String getCurrentUserId() {
		return "demo";
	}

}
