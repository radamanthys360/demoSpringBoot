package com.taringa.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import javax.validation.ConstraintViolation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex,WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExcepciones(NotFoundException ex,WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		String errores= "";
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errores += violation.getRootBeanClass().getName() + " " + 
	          violation.getPropertyPath() + ": " + violation.getMessage();
	    }
	 
	      ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validacion fallida", errores);
	      return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
