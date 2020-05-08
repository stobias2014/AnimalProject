package com.tobias.saul.AnimalService;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tobias.saul.AnimalService.pojos.Animal;
import com.tobias.saul.AnimalService.services.AnimalService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnimalServiceApplicationTests {
	
	@Autowired
	WebApplicationContext webctx;
	@Autowired
	MockMvc mockmvc;
	
	@Autowired
	ApplicationContext context;
	@Autowired
	AnimalService animalService;
	
	Animal animal;
	
	@Before
	public void setUp() throws Exception {
		mockmvc = MockMvcBuilders.webAppContextSetup(webctx).build();
	}
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void test_AddAnimalToDatabase() {
		animal = context.getBean(Animal.class);
		animal.setName("pet name");
		animalService.save(animal);
		
		assertEquals(animal, animalService.get(animal.getAnimalId()));
		
	}
	
	@Test
	public void test_UpdateAnimalInDatabase() {
		animal = context.getBean(Animal.class);
		animal.setName("wrong name");
		
		animalService.save(animal);
		
		animal.setName("right name");
		animalService.update(animal);
		
		assertEquals(animal, animalService.update(animal));
	}
	
	@Test
	public void test_DeleteAnimalInDatabase() {
		animal = context.getBean(Animal.class);
		animalService.save(animal);
		animalService.delete(animal.getAnimalId());
		
		assertNull(animalService.get(animal.getAnimalId()));
	}
	
	@Test
	public void test_GetAllAnimalsInDatabase() {
		animal = context.getBean(Animal.class);
		animalService.save(animal);
		
		assertTrue(animalService.getAll().contains(animal));
	}
	
}
