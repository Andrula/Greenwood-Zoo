package com.example.GreenwoodZoo.Repository;

import com.example.GreenwoodZoo.Model.Animal;
import com.example.GreenwoodZoo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
