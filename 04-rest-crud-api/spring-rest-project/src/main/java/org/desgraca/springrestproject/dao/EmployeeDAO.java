package org.desgraca.springrestproject.dao;

import org.desgraca.springrestproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findall();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
