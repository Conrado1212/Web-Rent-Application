package pl.edu.wszib.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.*;
import pl.edu.wszib.dao.impl.BuyDAOImpl;
import pl.edu.wszib.dao.impl.CustomerDAOImpl;
import pl.edu.wszib.dao.impl.EmployeeDAOImpl;
import pl.edu.wszib.dao.impl.VehicleDAOImpl;
import pl.edu.wszib.services.*;
import pl.edu.wszib.services.impl.*;

@Configuration
public class AppConfiguration {

    @Bean
    @SessionScope
    public SessionObject sessionObject(){
        return new SessionObject();
    }

    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public IVehicleDao vehicleDao(SessionFactory hibernateSessionFactory){
        return  new VehicleDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IVehicleServices vehicleServices(IVehicleDao vehicleDao){
        return new VehicleServiceImpl(vehicleDao);
    }

    @Bean
    public IEmployeeDao employeeDao(SessionFactory hibernateSessionFactory){
        return new EmployeeDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IEmployeeServices employeeServices(IEmployeeDao employeeDao){
        return new EmployeeServiceImpl(employeeDao);
    }

    @Bean
    public ICustomerDAO customerDAO(SessionFactory hibernateSessionFactory){
        return new CustomerDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public ICustomerServices customerServices(ICustomerDAO customerDAO){
        return new CustomerServiceImpl(customerDAO);
    }

    @Bean
    public IBuyDAO buyDAO(SessionFactory hibernateSessionFactory){
        return new BuyDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IBuyServices buyServices(IBuyDAO buyDAO){
        return new BuyServiceImpl(buyDAO);
    }



    @Bean
    public IAuthenticationService authenticationService(IUserAppDao userAppDao){
        return new AuthenticationServiceImpl(userAppDao);
    }



}
