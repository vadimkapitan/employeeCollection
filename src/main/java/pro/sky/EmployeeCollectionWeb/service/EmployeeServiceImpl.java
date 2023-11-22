package pro.sky.EmployeeCollectionWeb.service;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeCollectionWeb.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeCollectionWeb.exception.EmployeeNotFoundException;
import pro.sky.EmployeeCollectionWeb.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @Override
     public Collection<Employee> findAll() {
        return employees;
    }
}
