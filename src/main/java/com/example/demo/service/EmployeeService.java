package com.example.demo.service;
import com.example.demo.model.Employee;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;
public interface EmployeeService {
    public Optional<Employee> findById(ObjectId id);
    public List<Employee> findAll();
    public void Insert(Employee employee);
    public void Delete(ObjectId id);
    public void Edit(Employee employee);
    public List<Employee> findByFullNameLikeFullName(String fullName);
    public Employee findByFullName(String fullName);
}
