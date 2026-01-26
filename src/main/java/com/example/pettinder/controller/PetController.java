package com.example.pettinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pettinder.model.Pet;
import com.example.pettinder.service.PetService;

@Controller
public class PetController {
    
    @Autowired
    private PetService petService;
    
    // ========== LANDING PAGE ==========
    
    @GetMapping("/")
    public String landing() {
        return "landing";
    }
    
    // ========== USER ROUTES (For Pet Adopters) ==========
    
    @GetMapping("/user")
    public String userHome(Model model) {
        model.addAttribute("pets", petService.getAvailablePets());
        model.addAttribute("userMode", true);
        return "user-home";
    }
    
    @GetMapping("/user/pets/type/{type}")
    public String userGetPetsByType(@PathVariable String type, Model model) {
        model.addAttribute("pets", petService.getPetsByType(type));
        model.addAttribute("selectedType", type);
        model.addAttribute("userMode", true);
        return "user-home";
    }
    
    @GetMapping("/user/pet/{id}")
    public String userPetDetail(@PathVariable Long id, Model model) {
        petService.getPetById(id).ifPresent(pet -> model.addAttribute("pet", pet));
        model.addAttribute("userMode", true);
        return "pet-detail";
    }
    
    @PostMapping("/user/adopt/{id}")
    public String userAdoptPet(@PathVariable Long id) {
        petService.adoptPet(id);
        return "redirect:/user";
    }
    
    // ========== NGO ROUTES (For Pet Management) ==========
    
    @GetMapping("/ngo")
    public String ngoHome(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        model.addAttribute("ngoMode", true);
        return "ngo-home";
    }
    
    @GetMapping("/ngo/pets/type/{type}")
    public String ngoGetPetsByType(@PathVariable String type, Model model) {
        model.addAttribute("pets", petService.getPetsByType(type));
        model.addAttribute("selectedType", type);
        model.addAttribute("ngoMode", true);
        return "ngo-home";
    }
    
    @GetMapping("/ngo/pet/{id}")
    public String ngoPetDetail(@PathVariable Long id, Model model) {
        petService.getPetById(id).ifPresent(pet -> model.addAttribute("pet", pet));
        model.addAttribute("ngoMode", true);
        return "pet-detail";
    }
    
    @GetMapping("/ngo/add")
    public String ngoAddPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("ngoMode", true);
        return "add-pet";
    }
    
    @PostMapping("/ngo/add")
    public String ngoAddPet(@ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/ngo";
    }
    
    @PostMapping("/ngo/delete/{id}")
    public String ngoDeletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/ngo";
    }
}
