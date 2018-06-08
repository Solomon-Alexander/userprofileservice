package com.demo.userprofile.api.exception;

/**
 * @author Solomon.Alexander
 */
public class EntityNotFoundException extends UserProfileApiException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1595331078979818402L;

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}