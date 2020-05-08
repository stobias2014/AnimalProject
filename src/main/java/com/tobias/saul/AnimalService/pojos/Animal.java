package com.tobias.saul.AnimalService.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@Table(name = "animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long animalId;
	private String name;

	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalId == null) ? 0 : animalId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (animalId == null) {
			if (other.animalId != null)
				return false;
		} else if (!animalId.equals(other.animalId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [animalId=" + animalId + ", name=" + name + "]";
	}
	
	
	
	
	
	

}
