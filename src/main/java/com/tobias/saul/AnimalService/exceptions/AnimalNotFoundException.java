package com.tobias.saul.AnimalService.exceptions;

import org.springframework.http.HttpStatus;

public class AnimalNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1097877577515375649L;

	public AnimalNotFoundException(Long animalId) {
		super(HttpStatus.NOT_FOUND + " Could not find Animal [ " + animalId + " ]");
	}
}
