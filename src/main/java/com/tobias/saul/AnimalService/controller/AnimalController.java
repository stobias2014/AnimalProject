package com.tobias.saul.AnimalService.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.AnimalService.pojos.Animal;
import com.tobias.saul.AnimalService.services.AnimalService;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	
	@GetMapping("/animals")
	public List<Animal> findAll() {
		return animalService.getAll();
	}
	
	@GetMapping("/animals/{animalId}")
	public EntityModel<Animal> findAnimalById(@PathVariable("animalId") Long animalId) {
		
		Animal animal = animalService.get(animalId);
		
		return new EntityModel<>(animal,
			    linkTo(methodOn(AnimalController.class).findAnimalById(animalId)).withSelfRel(),
			    linkTo(methodOn(AnimalController.class).findAll()).withRel("animals"));
	}
	
	@PostMapping("/animals")
	public Animal saveAnimal(@RequestBody Animal animal) {
		return animalService.save(animal);
	}
	
	@PutMapping("/animals")
	public Animal updateAnimal(@RequestBody Animal animal) {
		return animalService.update(animal);
	}
	
	@DeleteMapping("/animals/{animalId}")
	public void deleteAnimal(@PathVariable("animalId") Long animalId) {
		animalService.delete(animalId);
	}
}
