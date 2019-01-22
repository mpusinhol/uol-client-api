package com.mpusinhol.clientapi.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mpusinhol.clientapi.services.exception.FetchLocationErrorException;
import com.mpusinhol.clientapi.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Not found",
				exception.getMessage(),
				request.getRequestURI()
			);
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(FetchLocationErrorException.class)
	public ResponseEntity<StandardError> malformedUrl(FetchLocationErrorException exception, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Error retrieving user location",
				exception.getMessage(),
				request.getRequestURI()
			);
		
		return ResponseEntity.status(status).body(error);
	} 
}
