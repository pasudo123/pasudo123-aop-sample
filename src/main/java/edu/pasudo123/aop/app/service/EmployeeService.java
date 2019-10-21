package edu.pasudo123.aop.app.service;

import edu.pasudo123.aop.app.dto.EmployeeDto;
import edu.pasudo123.aop.app.exception.ResourceNotFoundException;
import edu.pasudo123.aop.app.model.Employee;
import edu.pasudo123.aop.app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pasudo123 on 2019-10-21
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /** READ **/
    public Employee getEmployeeById(final Long employeeId) throws ResourceNotFoundException {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    }

    /** CREATE **/
    public Employee createEmployee(final EmployeeDto.Request dto) {
        return employeeRepository.save(dto.toEntity());
    }

    /** UPDATE **/
    public Employee updateEmployee(final Long employeeId, final EmployeeDto.Request dto) throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.updateEmployee(dto);

        return employeeRepository.save(employee);
    }

    /** DELETE **/
    public Map<String, Boolean> deleteEmployee(final Long employeeId)
            throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
