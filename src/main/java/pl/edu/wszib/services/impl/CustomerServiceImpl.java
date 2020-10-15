package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.ICustomerDAO;

import pl.edu.wszib.model.Customer;

import pl.edu.wszib.services.ICustomerServices;

public class CustomerServiceImpl implements ICustomerServices {
    @Autowired
    ICustomerDAO customerDAO;

    public CustomerServiceImpl(ICustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(Customer customer){
        Customer customerFromDb = this.customerDAO.getCustomer(customer.getIdCustomer());
        if(customerFromDb == null){
            this.customerDAO.addCustomer(customer);
        }
    }

    @Override
    public Customer getCustomer(int idCustomer){
        return this.customerDAO.getCustomer(idCustomer);
    }

    @Override
    public void getUpdate(int idCustomer, Customer customer){
        Customer customerFromDb = this.customerDAO.getUpdate(idCustomer,customer);
        if(customerFromDb == null){
            this.customerDAO.getUpdate(idCustomer,customer);
        }
    }

    @Override
    public void removeCustomerId(int idCustomer){
        Customer customerFromDb = this.customerDAO.removeCustomerId(idCustomer);
        if(customerFromDb == null){
            this.customerDAO.removeCustomerId(idCustomer);
        }
    }
}
