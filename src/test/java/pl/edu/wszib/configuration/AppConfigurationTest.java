package pl.edu.wszib.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.controllers.*;
import pl.edu.wszib.dao.ICustomerDAO;
import pl.edu.wszib.dao.IEmployeeDao;
import pl.edu.wszib.dao.IUserAppDao;
import pl.edu.wszib.dao.IVehicleDao;
import pl.edu.wszib.services.*;
import pl.edu.wszib.services.impl.*;

@Configuration
public class AppConfigurationTest {

    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public IAuthenticationService authenticationService(IUserAppDao userAppDao){
        return new AuthenticationServiceImpl(userAppDao);
    }

    @Bean
    public AuthorizationController authorizationController(){
        return new AuthorizationController();
    }

    @Bean
    public IVehicleServices vehicleServices(IVehicleDao vehicleDao){
        return new VehicleServiceImpl(vehicleDao);
    }

    @Bean
    public VehicleController vehicleController(){
        return new VehicleController();
    }

    @Bean
    public ICustomerServices customerServices(ICustomerDAO customerDAO){
        return new CustomerServiceImpl(customerDAO);
    }

    @Bean
    public CustomerController customerController(){
        return new CustomerController();
    }

    @Bean
    public IEmployeeServices employeeServices(IEmployeeDao employeeDao){
        return new EmployeeServiceImpl(employeeDao);
    }

    @Bean
    public EmployeeController employeeController(){
        return new EmployeeController();
    }

    @Bean
    public IUserAppServices userAppServices(IUserAppDao userAppDao){
        return new UserAppServiceImpl(userAppDao);
    }

    @Bean
    public UserAppController userAppController(){
        return new UserAppController();
    }
}
