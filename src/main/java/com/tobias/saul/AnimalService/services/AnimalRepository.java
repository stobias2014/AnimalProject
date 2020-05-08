package com.tobias.saul.AnimalService.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.AnimalService.pojos.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
