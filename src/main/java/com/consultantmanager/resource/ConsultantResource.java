package com.consultantmanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.consultantmanager.model.Consultant;
import com.consultantmanager.service.ConsultantService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class ConsultantResource {
    private final ConsultantService employeeService;

    public ConsultantResource(ConsultantService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Consultant>> getAllEmployees () {
        List<Consultant> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Consultant> getEmployeeById (@PathVariable("id") Long id) {
        Consultant employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consultant> addEmployee(@RequestBody Consultant employee) {
        Consultant newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Consultant> updateEmployee(@RequestBody Consultant employee) {
        Consultant updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
