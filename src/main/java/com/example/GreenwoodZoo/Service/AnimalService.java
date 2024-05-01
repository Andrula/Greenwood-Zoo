package com.example.GreenwoodZoo.Service;

import com.example.GreenwoodZoo.Model.Animal;
import com.example.GreenwoodZoo.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public boolean deleteAnimal(int id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isPresent()) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    public long countAnimals() {
        return animalRepository.count();
    }

    public int countAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species).size();
    }
}
