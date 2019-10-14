package com.proyecto.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.proyecto.bootcamp.repository.ItemReactiveRepository;
import com.proyecto.bootcamp.service.parentsService;
import com.proyecto.bootcamp.service.parentsServiceImpl;
import com.proyecto.bootcamp.web.parentsController;


@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackageClasses = ItemReactiveRepository.class)
@ComponentScan(basePackages = {
		"com.proyecto.bootcamp.ProyectoBootcampApplication",
		
	})
public class ProyectoBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBootcampApplication.class, args);
	}

}
