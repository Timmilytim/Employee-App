package com.tim.repository;

import com.tim.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // This interface will automatically provide CRUD operations for Employee entity
    // No need to define methods here, JpaRepository provides all necessary methods
}
