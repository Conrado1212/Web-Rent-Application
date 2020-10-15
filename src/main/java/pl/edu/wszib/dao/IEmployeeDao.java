package pl.edu.wszib.dao;

import pl.edu.wszib.model.Customer;
import pl.edu.wszib.model.Employee;

public interface IEmployeeDao {
    void addEmployee(Employee employee);

    Employee getEmployee(int idEmployee);

    Employee getUpdate(int idEmployee, Employee employee);


    void updateEmployee(int idEmployee, Employee employee);

    Employee removeEmployeeId(int idEmployee);

    java.util.List<Employee> getAllEmployee();
}
