package htw.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import htw.common.exception.ApiErrorResponse;
import htw.common.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException e, WebRequest request) {
		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withTimestamp(Instant.now().toEpochMilli())
				.withErrorCode(HttpStatus.NOT_FOUND.value())
				.withError(HttpStatus.NOT_FOUND.getReasonPhrase())
		        .withMessage(e.getMessage())
		        .build();
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("MethodArgumentNotValidException e "+e);
		
		StringBuilder sb = new StringBuilder();
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			sb.append("[").append(error.getField() +" "+ error.getDefaultMessage()).append("] ");
		}
		
		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withTimestamp(Instant.now().toEpochMilli())
				.withErrorCode(HttpStatus.BAD_REQUEST.value())
				.withError(HttpStatus.BAD_REQUEST.getReasonPhrase())
		        .withMessage(sb.toString())
		        .build();
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public void defaultExceptionHandler() {
		System.out.println("bad request");
	}
}
