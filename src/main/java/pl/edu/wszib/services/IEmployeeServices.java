package pl.edu.wszib.services;

import pl.edu.wszib.model.Employee;

public interface IEmployeeServices {
    void addEmployee(Employee employee);

    Employee getEmployee(int idEmployee);

    void getUpdate(int idEmployee, Employee employee);

    void removeEmployeeId(int idEmployee);
}
