package com.tobias.saul.AnimalService.exceptions;

public class AnimalNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1097877577515375649L;

	public AnimalNotFoundException(Long animalId) {
		super("Could not find Animal [ " + animalId + " ]");
	}
}
