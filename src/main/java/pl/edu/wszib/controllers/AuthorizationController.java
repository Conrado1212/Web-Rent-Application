package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.services.IAuthenticationService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AuthorizationController {


    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    IAuthenticationService authenticationService;

    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("userModel",new UserApp());
        model.addAttribute("errorMessage","");
        return "loginAndRegistry";
    }


    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.POST)
    public  String authenticateUser(@ModelAttribute("userModel")UserApp userApp, Model model){
        boolean authResult = this.authenticationService.authenticateUserApp(userApp);
        if(authResult){
            return "rentAppPage";
        }else{
            model.addAttribute("errorMessage","zle dane!!!");
            model.addAttribute("userModel",new UserApp());
            return "loginAndRegistry";
        }
    }


    @RequestMapping(value = "/loginAndRegistry",method = RequestMethod.POST)
    public String loginForm(@ModelAttribute("loginKey") UserApp userApp){
        if(userApp.getLogin().equals("admin") && userApp.getPassword().equals("admin") || userApp.getLogin().equals("admin1") && userApp.getPassword().equals("admin1")
                || userApp.getLogin().equals("admin2") && userApp.getPassword().equals("admin2") || userApp.getLogin().equals("admin3") && userApp.getPassword().equals("admin3")){
            System.out.println("Witaj jestes zalogowany!!");
            Date dNow = new Date( );
            SimpleDateFormat ft =
                    new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

            System.out.println("Current Date: " + ft.format(dNow));
            this.sessionObject.setUserApp(userApp);

            return "redirect:rentAppPage";
        }
        System.out.println(userApp);
        return "loginAndRegistry";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUserApp(null);
        System.out.println("Jestes wylogowany");
        Date dNow1 = new Date( );
        SimpleDateFormat ft1 =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft1.format(dNow1));

        return "redirect:loginAndRegistry";
    }


}
