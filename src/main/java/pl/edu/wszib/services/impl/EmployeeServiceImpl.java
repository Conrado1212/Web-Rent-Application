package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IEmployeeDao;
import pl.edu.wszib.dao.IVehicleDao;
import pl.edu.wszib.model.Customer;
import pl.edu.wszib.model.Employee;
import pl.edu.wszib.model.Vehicle;
import pl.edu.wszib.services.IEmployeeServices;

public class EmployeeServiceImpl implements IEmployeeServices {
    @Autowired
    IEmployeeDao employeeDao;

    public EmployeeServiceImpl(IEmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee){
        Employee employeeFromDb = this.employeeDao.getEmployee(employee.getIdEmployee());
        if(employeeFromDb == null){
            this.employeeDao.addEmployee(employee);
        }
    }

    @Override
    public Employee getEmployee(int idEmployee){
        return this.employeeDao.getEmployee(idEmployee);
    }

    @Override
    public void getUpdate(int idEmployee, Employee employee){
        Employee employeeFromDb = this.employeeDao.getUpdate(idEmployee,employee);
        if(employeeFromDb == null){
            this.employeeDao.getUpdate(idEmployee,employee);
        }
    }

    @Override
    public void removeEmployeeId(int idEmployee){
        Employee employeeFromDb = this.employeeDao.removeEmployeeId(idEmployee);
        if(employeeFromDb == null){
            this.employeeDao.removeEmployeeId(idEmployee);
        }
    }

}
