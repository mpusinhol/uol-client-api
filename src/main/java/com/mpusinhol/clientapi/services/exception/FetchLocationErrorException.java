package com.mpusinhol.clientapi.services.exception;

public class FetchLocationErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public FetchLocationErrorException(String message) {
		super(message);
	}
}