package com.example.GreenwoodZoo.Service;

import com.example.GreenwoodZoo.Model.Enclosure;
import com.example.GreenwoodZoo.Repository.EnclosureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnclosureService {

    @Autowired
    private EnclosureRepository enclosureRepository;

    // Get all enclosures
    public List<Enclosure> findAllEnclosures() {
        return enclosureRepository.findAll();
    }

    // Get an enclosure by ID
    public Optional<Enclosure> findEnclosureById(int id) {
        return enclosureRepository.findById(id);
    }

    // Create or update an enclosure
    public Enclosure saveOrUpdateEnclosure(Enclosure enclosure) {
        return enclosureRepository.save(enclosure);
    }

    // Delete an enclosure
    public void deleteEnclosure(int id) {
        enclosureRepository.deleteById(id);
    }
}
