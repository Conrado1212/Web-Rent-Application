package pl.edu.wszib.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;
import pl.edu.wszib.model.Buy;

@Slf4j
@Controller
public class FinishBuyController {

    @GetMapping
    public String showOrder(Model model, Buy buy, SessionStatus sessionStatus) {
        model.addAttribute("buys", buy.getIdBuy());

        model.addAttribute("idVehicle", buy.getIdVehicle());
        model.addAttribute("idCustomer", buy.getIdCustomer());
        model.addAttribute("ccNumber", buy.getCcNumber());
        model.addAttribute("ccExpiration", buy.getCcExpiration());
        model.addAttribute("ccCVV", buy.getCcCVV());
        sessionStatus.setComplete();
        return "finishBuy";
    }
}
