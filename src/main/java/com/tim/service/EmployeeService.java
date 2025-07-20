package com.tim.service;

import com.tim.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    Employee update(Employee theEmployee);
    void deleteById(int id);
}
