package pl.edu.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.VehicleDAOImpl;
import pl.edu.wszib.model.Vehicle;

@Controller
public class VehicleController {

    VehicleDAOImpl vehicleDAO;

    @RequestMapping(value = "/rentAppPage",method = RequestMethod.GET)
    public ModelAndView rentAppPage(){
        return new ModelAndView("rentAppPage","rentKey",new Vehicle());
    }

    @RequestMapping(value = "/rentAppPage",method = RequestMethod.POST)
    public String rentForm(@ModelAttribute("rentKey")Vehicle vehicle){
        System.out.println(vehicle);
        return "rentAppPage";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "rentAppPage";
    }

    @RequestMapping(value = "/addVehicle",method = RequestMethod.GET)
    public ModelAndView addVehicle(){
        return new ModelAndView("addVehicle","addVehicleKey",new Vehicle());
    }


    @RequestMapping(value = "/addVehicle",method = RequestMethod.POST)
    public String addVehicleForm(@ModelAttribute("addScooterKey")Vehicle vehicle){
        vehicleDAO.addVehicle(vehicle);
        return  "addVehicle";
    }


    @RequestMapping(value = "/removeVehicle",method = RequestMethod.GET)
    public ModelAndView removeVehicleId(){
        return new ModelAndView("removeVehicle","removeVehicleIdKey",new Vehicle());
    }

    @RequestMapping(value = "/removeVehicle",method = RequestMethod.POST)
    public String removeVehicleForm(@ModelAttribute("removeVehicleIdKey")Vehicle vehicle){
        vehicleDAO.removeVehicleId(vehicle.getIdVehicle());
        return "removeVehicle";
    }



    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    public ModelAndView removeVehicleBuyId(){
        return new ModelAndView("buy","removeVehicleBuyIdKey",new Vehicle());
    }

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public String removeVehicleBuyForm(@ModelAttribute("removeVehicleBuyIdKey")Vehicle vehicle){
        vehicleDAO.removeVehicleId(vehicle.getIdVehicle());
        return "buy";
    }






    @RequestMapping(value = "/getVehicle",method = RequestMethod.GET)
    public ModelAndView getVehicle(){
        return new ModelAndView("getVehicle","getVehicleKey",new Vehicle());
    }

    @RequestMapping(value = "/getVehicle",method = RequestMethod.POST)
    public String getVehicleForm(@ModelAttribute("getVehicleKey")Vehicle vehicle){
        vehicleDAO.getVehicle(vehicle.getIdVehicle());
        return "getVehicle";
    }

    @RequestMapping(value = "/updateVehicle",method = RequestMethod.GET)
    public ModelAndView updateVehicle(){
        return new ModelAndView("updateVehicle","updateVehicleKey",new Vehicle());
    }

    @RequestMapping(value = "/updateVehicle",method = RequestMethod.POST)
    public String updateVehicleForm(@ModelAttribute("updateVehicleKey")Vehicle vehicle){
        vehicleDAO.getUpdate(vehicle.getIdVehicle(),vehicle);
        return "updateVehicle";
    }

    @RequestMapping(value = "/updateVehicle",method = RequestMethod.GET)
    public ModelAndView updateVehicle2(){
        return new ModelAndView("updateVehicle","updateVehicleKey2",new Vehicle());
    }

    @RequestMapping(value = "/updateVehicle",method = RequestMethod.POST)
    public String updateVehicleForm2(@ModelAttribute("updateVehicleKey2")Vehicle vehicle){
        vehicleDAO.updateVehicle(vehicle.getIdVehicle(),vehicle);
        return "updateVehicle";
    }



}
