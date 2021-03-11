package com.atmfinder.exception;

public class AtmDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AtmDetailsNotFoundException() {
		super();
	}

	public AtmDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AtmDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AtmDetailsNotFoundException(String message) {
		super(message);
	}

	public AtmDetailsNotFoundException(Throwable cause) {
		super(cause);
	}
	

}
