package com.aliction.animalscounterspringboot;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("animals")
public class AnimalsResource {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    MeterRegistry meterRegistry;


    @GetMapping("{type}")
    public List<Animal> GetAnimal(@PathVariable(value = "type") String type){
	List<Animal> animals = new ArrayList<>();
	animalRepository.findByType(type).forEach(animals::add);
        return animals;
    }

    @DeleteMapping("{id}")
    public String DeleteAnimal (@PathVariable(value = "id") Long id ){
        Animal animal = animalRepository.findById(id).get();
        animalRepository.deleteById(id);
        // System.out.println(animal.id + " " + animal.name + " " + animal.type);
        // animalRepository.delete(animal);
        return "Animal with id " + id + " and type " + animal.type + " has been deleted.";
    }

    @PostMapping("dogs/{name}")
    public String Dogs(@PathVariable(value = "name") String name){
        meterRegistry.counter("animals.dogs.count").increment();
        Animal dog = new Animal(name, "dog", 1);
        animalRepository.save(dog);
        return "Adding a new dog " + name;
    }

    @PostMapping("cats/{name}")
    public String Cats(@PathVariable(value = "name") String name){
        meterRegistry.counter("animals.cats.count").increment();
        Animal cat = new Animal(name, "cat", 1);
        animalRepository.save(cat);
        return "Adding a new cat " + name;
    }

    @PostMapping("horses/{name}")
    public String Horses(@PathVariable(value = "name") String name){
        meterRegistry.counter("animals.horses.count").increment();
        Animal horse = new Animal(name, "horse", 1);
        animalRepository.save(horse);
        return "Adding a new horse " + name;
    }

    
}
