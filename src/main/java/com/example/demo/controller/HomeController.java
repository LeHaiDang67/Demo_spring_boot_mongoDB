package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {
    @Autowired
    private EmployeeService EmployeeService;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("list",EmployeeService.findAll());
        return "admin/home";
    }
    @PostMapping("/add")
    public String NewEmployee(Model model, Employee employee){
        Employee oldEmployee= EmployeeService.findByFullName(employee.getFullName());
        if (oldEmployee !=null){
            model.addAttribute("list",EmployeeService.findAll());
            return "admin/home";
        }
        EmployeeService.Insert(employee);
        model.addAttribute("list",EmployeeService.findAll());
        return "admin/home";
    }
    @GetMapping("/delete/{id}")
    public String DeleteEmployee(Model model, @PathVariable(name = "id") ObjectId id){
       EmployeeService.Delete(id);
       model.addAttribute("list",EmployeeService.findAll());
       return "admin/home";
    }
    @GetMapping("/edit/{id}")
    public String EditEmployee(Model model, @PathVariable(name = "id") ObjectId id){
        Optional<Employee> employee = EmployeeService.findById(id);
        model.addAttribute("employee", employee);
        return "admin/edit";
    }
    @PostMapping("/edit")
    public String EditEmployee(Model model,@Valid Employee employee){
        EmployeeService.Edit(employee);
        model.addAttribute("list",EmployeeService.findAll());
        return "admin/home";
    }
    @PostMapping("/find")
    public String FindEmployee(Model model, Employee employee){
        if (employee.getFullName()==""){
            model.addAttribute("list",EmployeeService.findAll());
            return "admin/home";

        }
        model.addAttribute("list", EmployeeService.findByFullNameLikeFullName(employee.getFullName()));
        return "admin/home";
    }
}
