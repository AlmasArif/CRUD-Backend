package com.company.employee.service;

import com.company.employee.entity.Employee;
import com.company.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee emp = repository.findById(id).orElse(null);
        if (emp == null) return null;

        emp.setFullName(updatedEmployee.getFullName());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setMobile(updatedEmployee.getMobile());
        emp.setDepartment(updatedEmployee.getDepartment());
        emp.setDesignation(updatedEmployee.getDesignation());
        emp.setDateOfJoining(updatedEmployee.getDateOfJoining());
        emp.setStatus(updatedEmployee.getStatus());

        return repository.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

