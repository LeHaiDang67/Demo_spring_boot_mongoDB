package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    List<Employee> findByFullNameLikeOrderByFullName(String fullName);
    Employee findByFullName(String fullName);

}
