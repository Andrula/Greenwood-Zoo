package com.example.GreenwoodZoo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Enclosures")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double size;

    @OneToMany(mappedBy = "enclosure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animals;

    @ManyToMany(mappedBy = "enclosure")
    private List<Employee> employees;
}
