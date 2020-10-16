package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IEmployeeDao;
import pl.edu.wszib.model.Employee;

import java.util.List;

public class EmployeeDAOImplStub implements IEmployeeDao {
    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployee(int idEmployee) {
        return null;
    }

    @Override
    public Employee getUpdate(int idEmployee, Employee employee) {
        return null;
    }

    @Override
    public void updateEmployee(int idEmployee, Employee employee) {

    }

    @Override
    public Employee removeEmployeeId(int idEmployee) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }
}
