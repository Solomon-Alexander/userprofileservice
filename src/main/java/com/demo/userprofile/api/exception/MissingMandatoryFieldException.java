package com.demo.userprofile.api.exception;

/**
 * @author Solomon.Alexander
 */
public class MissingMandatoryFieldException extends UserProfileApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1901236013226031468L;

	public MissingMandatoryFieldException(String message) {
		super(message);
	}

	public MissingMandatoryFieldException(String message, Throwable cause) {
		super(message, cause);
	}
}