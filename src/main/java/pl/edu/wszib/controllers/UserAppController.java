package pl.edu.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.UserAppDAOImpl;
import pl.edu.wszib.model.Customer;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.model.Vehicle;

@Controller
public class UserAppController {


    UserAppDAOImpl userAppDAO;


    @RequestMapping(value = "/addCustomer",method = RequestMethod.GET)
    public ModelAndView addCustomerU(){
        return new ModelAndView("addCustomer","addUserAppKey",new UserApp());
    }

    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    public String addCustomerFormU(@ModelAttribute("addUserAppKey") UserApp userApp){
        userAppDAO.addUserApp(userApp);
        return  "addCustomer";
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.GET)
    public ModelAndView addEmployeeU(){
        return new ModelAndView("addEmployee","addUserAppKey",new UserApp());
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public String addEmployeeFormU(@ModelAttribute("addUserAppKey") UserApp userApp){
        userAppDAO.addUserApp(userApp);
        return  "addEmployee";
    }


    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.GET)
    public ModelAndView addCustomerR(){
        return new ModelAndView("loginAndRegistry","addUserAppKey",new UserApp());
    }

    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.POST)
    public String addCustomerFormR(@ModelAttribute("addUserAppKey") UserApp userApp){
        userAppDAO.addUserApp(userApp);
        return  "loginAndRegistry";
    }


}
