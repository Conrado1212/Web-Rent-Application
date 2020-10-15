package pl.edu.wszib.dao;

import pl.edu.wszib.model.Customer;

public interface ICustomerDAO {
    void addCustomer(Customer customer);

    Customer getCustomer(int idCustomer);

    Customer getUpdate(int idCustomer, Customer customer);

    void updateCustomer(int idCustomer, Customer customer);

    Customer removeCustomerId(int idCustomer);

    java.util.List<Customer> getAllCustomer();
}
