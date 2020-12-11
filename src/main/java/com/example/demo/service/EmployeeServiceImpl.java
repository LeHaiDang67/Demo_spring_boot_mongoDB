package com.example.demo.service;

import com.example.demo.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository EmployeeRepository;
    @Override
    public Optional<Employee> findById(ObjectId id) {
        return EmployeeRepository.findById(id);
    }
    @Override
    public List<Employee> findAll(){
        return  EmployeeRepository.findAll();
    }
    @Override
    public void Insert(Employee employee){
        EmployeeRepository.save(employee);
    }
    @Override
    public void Delete(ObjectId id){
        EmployeeRepository.deleteById(id);
    }

    @Override
    public void Edit(Employee employee) {
        EmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByFullNameLikeFullName(String fullName) {
        return EmployeeRepository.findByFullNameLikeOrderByFullName(fullName);
    }

    @Override
    public Employee findByFullName(String fullName) {
        return EmployeeRepository.findByFullName(fullName);
    }

}
