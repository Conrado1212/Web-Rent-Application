package pl.edu.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.BuyDAOImpl;
import pl.edu.wszib.model.Buy;


@Controller
public class BuyController {

    BuyDAOImpl buyDAO;


    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    public ModelAndView addBuy(){
        return new ModelAndView("buy","addBuyKey",new Buy());
    }

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public String addBuyForm(@ModelAttribute("addBuyKey") Buy buy){
        buyDAO.addBuy(buy);
        return  "buy";
    }
}
