package com.tim.service;

import com.tim.dao.EmployeeRepository;
import com.tim.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public Employee update(Employee theEmployee) {
        Employee existingEmployee = findById(theEmployee.getId());
        if (theEmployee.getFirstName() != null){
            existingEmployee.setFirstName(theEmployee.getFirstName());
        }
        if (theEmployee.getLastName() != null){
            existingEmployee.setLastName(theEmployee.getLastName());
        }
        if(theEmployee.getEmail() != null){
            existingEmployee.setEmail(theEmployee.getEmail());
        }
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
