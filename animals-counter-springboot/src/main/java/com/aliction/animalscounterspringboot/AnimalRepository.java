package com.aliction.animalscounterspringboot;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	List<Animal> findByType(String type);

}
