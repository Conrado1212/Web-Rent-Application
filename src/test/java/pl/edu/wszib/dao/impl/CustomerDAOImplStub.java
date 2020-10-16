package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.ICustomerDAO;
import pl.edu.wszib.model.Customer;

import java.util.List;

public class CustomerDAOImplStub implements ICustomerDAO {
    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomer(int idCustomer) {
        return null;
    }

    @Override
    public Customer getUpdate(int idCustomer, Customer customer) {
        return null;
    }

    @Override
    public void updateCustomer(int idCustomer, Customer customer) {

    }

    @Override
    public Customer removeCustomerId(int idCustomer) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }
}
