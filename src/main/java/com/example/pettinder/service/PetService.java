package com.example.pettinder.service;

import com.example.pettinder.model.Pet;
import com.example.pettinder.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;
    
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    
    public List<Pet> getAvailablePets() {
        return petRepository.findByAdoptedFalse();
    }
    
    public List<Pet> getPetsByType(String type) {
        return petRepository.findByTypeAndAdoptedFalse(type);
    }
    
    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }
    
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }
    
    public void adoptPet(Long id) {
        Optional<Pet> petOpt = petRepository.findById(id);
        if (petOpt.isPresent()) {
            Pet pet = petOpt.get();
            pet.setAdopted(true);
            petRepository.save(pet);
        }
    }
    
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}