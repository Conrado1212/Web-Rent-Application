package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IEmployeeDao;
import pl.edu.wszib.model.Customer;
import pl.edu.wszib.model.Employee;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public class EmployeeDAOImpl implements IEmployeeDao {
    @Autowired
    SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addEmployee(Employee employee){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally {
            session.close();
        }
    }
    @Override
    public Employee getEmployee(int idEmployee){
        Session session = this.sessionFactory.openSession();
        Employee employee =
                (Employee) session.createQuery("FROM pl.edu.wszib.model.Employee WHERE idEmployee = " + idEmployee).uniqueResult();

        session.close();
        return employee;
    }
    @Override
    public Employee getUpdate(int idEmployee, Employee employee){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(Employee.class,idEmployee);

            session.update(employee);
            tx.commit();
        }catch (HibernateException e){
            if(tx !=null); tx.rollback();
        }finally {
            session.close();
        }
        return  employee;
        //sprawdzic update
    }

    @Override
    public  void updateEmployee(int idEmployee, Employee employee){
        Session session = null;
        Transaction tx = null;
        Employee employee1;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            employee1 = (Employee)session.load(Employee.class,idEmployee);

            if(!(employee.getName().equals(""))){
                employee1.setName(employee.getName());
            }
            if(!(employee.getSurname().equals(""))){
                employee1.setSurname(employee.getSurname());
            }
            if(!(employee.getPesel()==0)){
                employee1.setPesel(employee.getPesel());
            }
            if(!(employee.getPhoneNumber().equals(""))){
                employee1.setPhoneNumber(employee.getPhoneNumber());
            }

            if(!(employee.getEmail().equals(""))){
                employee1.setEmail(employee.getEmail());
            }


            if(!(employee.getJobPosition()==0)){
                employee1.setJobPosition(employee.getJobPosition());
            }

        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }












    @Override
    public Employee removeEmployeeId(int idEmployee){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, idEmployee);
            session.delete(employee);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public java.util.List<Employee> getAllEmployee() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<Employee> allEmployee = session.createQuery("FROM pl.edu.wszib.model.Employee").list();

        return allEmployee;
    }
}
