package com.tobias.saul.AnimalService.assesmbler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.tobias.saul.AnimalService.controller.AnimalController;
import com.tobias.saul.AnimalService.pojos.Animal;

@Component
public class AnimalModelAssembler implements RepresentationModelAssembler<Animal, EntityModel<Animal>>{

	@Override
	public EntityModel<Animal> toModel(Animal animal) {
		return new EntityModel<>(animal,
			    linkTo(methodOn(AnimalController.class).findAnimalById(animal.getAnimalId())).withSelfRel(),
			    linkTo(methodOn(AnimalController.class).findAll()).withRel("animals"));
	}

}
