package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.dao.impl.CustomerDAOImpl;


public class CustomersController {
    @Autowired
    CustomerDAOImpl customerDAO;


    @RequestMapping(value = "/allCustomer",method = RequestMethod.GET)
    public String allCustomer(Model model){

        model.addAttribute("allCustomer",customerDAO.getAllCustomer());
        return "allCustomer";
    }
}
