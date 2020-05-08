package com.tobias.saul.AnimalService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.AnimalService.exceptions.AnimalNotFoundException;
import com.tobias.saul.AnimalService.pojos.Animal;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;

	public Animal save(Animal animal) {
		return animalRepository.save(animal);
	}

	public Animal get(Long animalId) {
		Animal animal = animalRepository
				.findById(animalId)
				.orElseThrow(() -> new AnimalNotFoundException(animalId));
	
		return animal;
	}

	public Animal update(Animal animal) {
		if(animalRepository.existsById(animal.getAnimalId())) {
			return animalRepository.save(animal);
		} else {
			System.out.println("Animal does not exist in database");
			return null;
		}
	}

	public void delete(Long animalId) {
		animalRepository.delete(animalRepository.getOne(animalId));
		
	}

	public List<Animal> getAll() {
		return animalRepository.findAll();
	}
	
	

}
