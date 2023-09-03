package com.vaccinemanagement.exceptions;

public class CitizenNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CitizenNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CitizenNotFoundException (String message) {
		super(message);
	}

	public CitizenNotFoundException(Throwable cause) {
		super(cause);
	}


}
