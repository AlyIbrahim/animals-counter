package com.aliction.animalscounterspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AnimalsCounterSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalsCounterSpringbootApplication.class, args);
	}

}
