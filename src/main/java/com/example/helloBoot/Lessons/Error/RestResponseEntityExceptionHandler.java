package com.example.helloBoot.Lessons.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.helloBoot.Lessons.Entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	//this class handles all particular exceptions on the controller layer and sends proper meaningful response back to client.
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFound(DepartmentNotFoundException e , WebRequest r)
	{
		ErrorMessage m = new ErrorMessage(HttpStatus.NOT_FOUND , "Department Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(m);
	}

}
