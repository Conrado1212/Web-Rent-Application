package pl.edu.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.CustomerDAOImpl;

import pl.edu.wszib.model.Customer;


@Controller
public class CustomerController {

    CustomerDAOImpl customerDAO;



    @RequestMapping(value = "/addCustomer",method = RequestMethod.GET)
    public ModelAndView addCustomer(){
        return new ModelAndView("addCustomer","addCustomerKey",new Customer());
    }

    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    public String addCustomerForm(@ModelAttribute("addCustomerKey") Customer customer){
        customerDAO.addCustomer(customer);
        return  "addCustomer";
    }

    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.GET)
    public ModelAndView addCustomerR(){
        return new ModelAndView("loginAndRegistry","addCustomerKey",new Customer());
    }

    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.POST)
    public String addCustomerFormR(@ModelAttribute("addCustomerKey") Customer customer){
        customerDAO.addCustomer(customer);
        return  "loginAndRegistry";
    }



    @RequestMapping(value = "/removeCustomer",method = RequestMethod.GET)
    public ModelAndView removeCustomerId(){
        return new ModelAndView("removeCustomer","removeCustomerIdKey",new Customer());
    }

    @RequestMapping(value = "/removeCustomer",method = RequestMethod.POST)
    public String removeCustomerIdForm(@ModelAttribute("removeCustomerIdKey")Customer customer){
        customerDAO.removeCustomerId(customer.getIdCustomer());
        return "removeCustomer";
    }




    @RequestMapping(value = "/getCustomer",method = RequestMethod.GET)
    public ModelAndView getCustomer(){
        return new ModelAndView("getCustomer","getCustomerKey",new Customer());
    }

    @RequestMapping(value = "/getCustomer",method = RequestMethod.POST)
    public String getCustomerForm(@ModelAttribute("getCustomerKey")Customer customer){
        customerDAO.getCustomer(customer.getIdCustomer());
        return "getCustomer";
    }

    @RequestMapping(value = "/updateCustomer",method = RequestMethod.GET)
    public ModelAndView updateEmployee(){
        return new ModelAndView("updateCustomer","updateCustomerKey",new Customer());
    }

    @RequestMapping(value = "/updateCustomer",method = RequestMethod.POST)
    public String updateCustomerForm(@ModelAttribute("updateCustomerKey")Customer customer){
        customerDAO.getUpdate(customer.getIdCustomer(),customer);
        return "updateCustomer";
    }


    @RequestMapping(value = "/updateCustomer",method = RequestMethod.GET)
    public ModelAndView updateEmployee2(){
        return new ModelAndView("updateCustomer","updateCustomerKey2",new Customer());
    }

    @RequestMapping(value = "/updateCustomer",method = RequestMethod.POST)
    public String updateCustomerForm2(@ModelAttribute("updateCustomerKey2")Customer customer){
        customerDAO.updateCustomer(customer.getIdCustomer(),customer);
        return "updateCustomer";
    }



}
