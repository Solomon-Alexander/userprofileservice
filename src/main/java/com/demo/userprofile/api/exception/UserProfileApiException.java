package com.demo.userprofile.api.exception;

/**
 * @author Solomon.Alexander
 */
public abstract class UserProfileApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1256671219899520653L;

	public UserProfileApiException(String message) {
		super(message);
	}

	public UserProfileApiException(String message, Throwable cause) {
		super(message, cause);
	}
}
