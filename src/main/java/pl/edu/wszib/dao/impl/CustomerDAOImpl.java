package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.ICustomerDAO;
import pl.edu.wszib.model.Customer;


import java.util.List;

public class CustomerDAOImpl implements ICustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addCustomer(Customer customer){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally {
            session.close();
        }
    }
    @Override
    public Customer getCustomer(int idCustomer){
        Session session = this.sessionFactory.openSession();
       Customer customer =
                (Customer) session.createQuery("FROM pl.edu.wszib.model.Customer WHERE idCustomer = " + idCustomer).uniqueResult();

        session.close();
        return customer;
    }
    @Override
    public Customer getUpdate(int idCustomer, Customer customer){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(Customer.class,idCustomer);

            session.update(customer);
            tx.commit();
        }catch (HibernateException e){
            if(tx !=null); tx.rollback();
        }finally {
            session.close();
        }
        return  customer;
        //sprawdzic update
    }
    @Override
    public  void updateCustomer(int idCustomer, Customer customer){
        Session session = null;
        Transaction tx = null;
        Customer customer1;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            customer1 = (Customer)session.load(Customer.class,idCustomer);

            if(!(customer.getName().equals(""))){
                customer1.setName(customer.getName());
            }
            if(!(customer.getSurname().equals(""))){
                customer1.setSurname(customer.getSurname());
            }
            if(!(customer.getEmail().equals(""))){
                customer1.setEmail(customer.getEmail());
            }
            if(!(customer.getPhone().equals(""))){
                customer1.setPhone(customer.getPhone());
            }

            if(!(customer.getLocation().x==0 && customer.getLocation().y==0)){
                customer1.setLocation(customer.getLocation());
            }
            if(!(customer.getLocationName().equals(""))){
                customer1.setLocationName(customer.getLocationName());
            }
            if(!(customer.getBorder().npoints==0)){
                customer1.setBorder(customer.getBorder());
            }

        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }



    @Override
    public Customer removeCustomerId(int idCustomer){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Customer customer =
                    (Customer) session.get(Customer.class, idCustomer);
            session.delete(customer);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public java.util.List<Customer> getAllCustomer() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Customer> allCustomer = session.createQuery("FROM pl.edu.wszib.model.Customer").list();

        return allCustomer;
    }

}
