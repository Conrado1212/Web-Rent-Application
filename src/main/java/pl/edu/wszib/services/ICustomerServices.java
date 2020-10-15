package pl.edu.wszib.services;

import pl.edu.wszib.model.Customer;


public interface ICustomerServices {


    void addCustomer(Customer customer);

    Customer getCustomer(int idCustomer);

    void getUpdate(int idCustomer, Customer customer);

    void removeCustomerId(int idCustomer);
}
