package pl.edu.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.EmployeeDAOImpl;
import pl.edu.wszib.model.Employee;

@Controller
public class EmployeeController {

    EmployeeDAOImpl employeeDAO;

    @RequestMapping(value = "/addEmployee",method = RequestMethod.GET)
    public ModelAndView addEmployee(){
        return new ModelAndView("addEmployee","addEmployeeKey",new Employee());
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public String addEmployeeForm(@ModelAttribute("addScooterKey")Employee employee){
        employeeDAO.addEmployee(employee);
        return  "addEmployee";
    }




    @RequestMapping(value = "/removeEmployee",method = RequestMethod.GET)
    public ModelAndView removeEmployeeId(){
        return new ModelAndView("removeEmployee","removeEmployeeIdKey",new Employee());
    }

    @RequestMapping(value = "/removeEmployee",method = RequestMethod.POST)
    public String removeScooterIdForm(@ModelAttribute("removeEmployeeIdKey")Employee employee){
        employeeDAO.removeEmployeeId(employee.getIdEmployee());
        return "removeEmployee";
    }



    @RequestMapping(value = "/getEmployee",method = RequestMethod.GET)
    public ModelAndView getEmployee(){
        return new ModelAndView("getEmployee","getEmployeeKey",new Employee());
    }

    @RequestMapping(value = "/getEmployee",method = RequestMethod.POST)
    public String getScooterForm(@ModelAttribute("getScooterKey")Employee employee){
        employeeDAO.getEmployee(employee.getIdEmployee());
        return "getEmployee";
    }


    @RequestMapping(value = "/updateEmployee",method = RequestMethod.GET)
    public ModelAndView updateEmployee(){
        return new ModelAndView("updateEmployee","updateEmployeeKey",new Employee());
    }

    @RequestMapping(value = "/updateEmployee",method = RequestMethod.POST)
    public String updateScooterForm(@ModelAttribute("updateScooterKey")Employee employee){
        employeeDAO.getUpdate(employee.getIdEmployee(),employee);
        return "updateEmployee";
    }


    @RequestMapping(value = "/updateEmployee",method = RequestMethod.GET)
    public ModelAndView updateEmployee2(){
        return new ModelAndView("updateEmployee","updateEmployeeKey2",new Employee());
    }

    @RequestMapping(value = "/updateEmployee",method = RequestMethod.POST)
    public String updateScooterForm2(@ModelAttribute("updateEmployeeKey2")Employee employee){
        employeeDAO.updateEmployee(employee.getIdEmployee(),employee);
        return "updateEmployee";
    }
}
