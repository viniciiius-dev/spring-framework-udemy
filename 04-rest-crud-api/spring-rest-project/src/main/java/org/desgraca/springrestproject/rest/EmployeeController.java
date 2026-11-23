package org.desgraca.springrestproject.rest;

import org.desgraca.springrestproject.entity.Employee;
import org.desgraca.springrestproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final JsonMapper jsonMapper;
    @Autowired
    public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.findById(employeeId);
        if (dbEmployee == null){
            throw new RuntimeException("Employee is not found");
        }
        return dbEmployee;

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayLoad){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee ID was not found: " + employeeId);
        }
        if (patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee ID is not allowed in body -" + employeeId);
        }
        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayLoad);
        return employeeService.save(patchedEmployee);

    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("employee doesn't exist in the database");
        }
        employeeService.deleteById(employeeId);
    }
}
