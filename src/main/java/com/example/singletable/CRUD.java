package com.example.singletable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.singletable.entity.Human;
import com.example.singletable.entity.Animals;
import com.example.singletable.entity.Species;

import com.example.singletable.repo.AnimalsRepo;
import com.example.singletable.repo.SpeciesRepo;

@Service
public class CRUD {

	@Autowired
	AnimalsRepo repo;

	@Autowired
	SpeciesRepo speciesRepo;

	Species animal = new Animals("red", 1022.3);
	Species human = new Human("brown", 32.3);

	public void saveAnimal() {
//		speciesRepo.save(animal);     // error
		repo.save(animal);
	}

	public void saveHuman() {
		repo.save(human);
	}

}
