package com.tobias.saul.AnimalService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.AnimalService.pojos.Animal;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;

	public void save(Animal animal) {
		animalRepository.save(animal);
	}

	public Animal get(Long animalId) {
		Optional<Animal> animal = animalRepository.findById(animalId);
		if(animal.isPresent()) {
			return animalRepository.findById(animalId).get();
		} 
		
		return null;
	}

	public void update(Animal animal) {
		if(animalRepository.existsById(animal.getAnimalId())) {
			animalRepository.save(animal);
		} else {
			System.out.println("Animal does not exist in database");
		}
	}

	public void delete(Animal animal) {
		animalRepository.delete(animal);
		
	}

	public List<Animal> getAll() {
		// TODO Auto-generated method stub
		return animalRepository.findAll();
	}
	
	

}
