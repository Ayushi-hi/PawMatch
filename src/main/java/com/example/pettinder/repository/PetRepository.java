package com.example.pettinder.repository;

import com.example.pettinder.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAdoptedFalse();
    List<Pet> findByType(String type);
    List<Pet> findByTypeAndAdoptedFalse(String type);
}