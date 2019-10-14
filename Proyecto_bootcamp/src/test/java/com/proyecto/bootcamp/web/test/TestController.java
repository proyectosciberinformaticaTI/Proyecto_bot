package com.proyecto.bootcamp.web.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.proyecto.bootcamp.ProyectoBootcampApplication;
import com.proyecto.bootcamp.web.parentsController;





@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = parentsController.class)
@ContextConfiguration(classes = {ProyectoBootcampApplication.class})
public class TestController {

	ObjectMapper mapper;
	


	  
	  
	  
	  @BeforeEach
	  public void init() {
		  
		  mapper= new ObjectMapper();
	  }
	
	@Test
	public void index() {
		
		
		
		
		assertEquals(1, 1);
		
		
	}
	
	
	

}
