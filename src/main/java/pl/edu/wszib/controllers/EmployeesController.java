package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.dao.impl.EmployeeDAOImpl;



public class EmployeesController {
    @Autowired
    EmployeeDAOImpl employeeDAO;


    @RequestMapping(value = "/allEmployee",method = RequestMethod.GET)
    public String allEmployee(Model model){

        model.addAttribute("allEmployee",employeeDAO.getAllEmployee());
        return "allEmployee";
    }


}
