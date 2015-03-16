package org.plateau.angang.permission;

/**
 * 权限验证失败后会抛出此异常。
 * 
 * @author quinn
 */
public class PermissionDeniedException extends RuntimeException {

	private static final long serialVersionUID = -5076874172136386197L;

	public PermissionDeniedException() {
		super();
	}

	public PermissionDeniedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PermissionDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissionDeniedException(String message) {
		super(message);
	}

	public PermissionDeniedException(Throwable cause) {
		super(cause);
	}

}
