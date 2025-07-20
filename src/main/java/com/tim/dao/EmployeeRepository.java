package com.tim.dao;

import com.tim.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // This interface will automatically provide CRUD operations for Employee entity
    // No need to define methods here, JpaRepository provides all necessary methods
}
