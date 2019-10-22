package edu.pasudo123.aop.app.controller;

import edu.pasudo123.aop.app.dto.EmployeeDto;
import edu.pasudo123.aop.app.exception.ResourceNotFoundException;
import edu.pasudo123.aop.app.model.Employee;
import edu.pasudo123.aop.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by pasudo123 on 2019-10-21
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody @Valid EmployeeDto.Request dto) {
        return employeeService.createEmployee(dto);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,
                                                   @RequestBody @Valid EmployeeDto.Request dto) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(employeeService.updateEmployee(id, dto));
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {

        return employeeService.deleteEmployee(employeeId);
    }
}
