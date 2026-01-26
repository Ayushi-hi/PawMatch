package com.example.pettinder.config;

import com.example.pettinder.model.Pet;
import com.example.pettinder.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private PetRepository petRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Add sample pets
        petRepository.save(new Pet(
            "Max", 
            "Dog", 
            "Golden Retriever", 
            3, 
            "Friendly and playful golden retriever looking for a loving home!",
            "https://images.unsplash.com/photo-1633722715463-d30f4f325e24?w=400",
            "New York, NY"
        ));
        
        petRepository.save(new Pet(
            "Luna", 
            "Cat", 
            "Siamese", 
            2, 
            "Elegant and affectionate Siamese cat who loves cuddles.",
            "https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?w=400",
            "Los Angeles, CA"
        ));
        
        petRepository.save(new Pet(
            "Charlie", 
            "Dog", 
            "Beagle", 
            4, 
            "Energetic beagle who loves walks and playing fetch!",
            "https://images.unsplash.com/photo-1505628346881-b72b27e84530?w=400",
            "Chicago, IL"
        ));
        
        petRepository.save(new Pet(
            "Bella", 
            "Cat", 
            "Persian", 
            1, 
            "Beautiful Persian kitten with a sweet temperament.",
            "https://images.unsplash.com/photo-1574158622682-e40e69881006?w=400",
            "Houston, TX"
        ));
        
        petRepository.save(new Pet(
            "Buddy", 
            "Dog", 
            "Labrador", 
            5, 
            "Loyal and gentle Labrador, great with kids!",
            "https://images.unsplash.com/photo-1552053831-71594a27632d?w=400",
            "Phoenix, AZ"
        ));
        
        petRepository.save(new Pet(
            "Whiskers", 
            "Cat", 
            "Tabby", 
            3, 
            "Playful tabby cat who enjoys toys and naps.",
            "https://images.unsplash.com/photo-1529778873920-4da4926a72c2?w=400",
            "Philadelphia, PA"
        ));
        
        System.out.println("✅ Sample pet data initialized successfully!");
    }
}
