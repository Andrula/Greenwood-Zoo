package com.example.GreenwoodZoo.Controller;

import com.example.GreenwoodZoo.Model.Enclosure;
import com.example.GreenwoodZoo.Service.EnclosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enclosures") // Base path for all endpoints in this controller
public class EnclosureController {

    @Autowired
    private EnclosureService enclosureService;

    // GET request to retrieve all enclosures
    @GetMapping
    public List<Enclosure> getAllEnclosures() {
        return enclosureService.findAllEnclosures();
    }

    // GET request to retrieve a single enclosure by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enclosure> getEnclosureById(@PathVariable int id) {
        Optional<Enclosure> enclosure = enclosureService.findEnclosureById(id);
        return enclosure.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST request to create a new enclosure
    @PostMapping
    public ResponseEntity<Enclosure> createEnclosure(@RequestBody Enclosure enclosure) {
        Enclosure savedEnclosure = enclosureService.saveOrUpdateEnclosure(enclosure);
        return new ResponseEntity<>(savedEnclosure, HttpStatus.CREATED);
    }

    // DELETE request to delete an enclosure
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnclosure(@PathVariable int id) {
        Optional<Enclosure> enclosure = enclosureService.findEnclosureById(id);
        if (enclosure.isPresent()) {
            enclosureService.deleteEnclosure(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
