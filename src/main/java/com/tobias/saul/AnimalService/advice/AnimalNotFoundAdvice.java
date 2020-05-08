package com.tobias.saul.AnimalService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tobias.saul.AnimalService.exceptions.AnimalNotFoundException;

@ControllerAdvice
public class AnimalNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(AnimalNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String animalNotFoundHandler(AnimalNotFoundException e) {
		return e.getMessage();
	}

}
