package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IBuyDAO;
import pl.edu.wszib.model.Buy;
import pl.edu.wszib.services.IBuyServices;

public class BuyServiceImpl implements IBuyServices {
    @Autowired
    IBuyDAO buyDAO;


    public BuyServiceImpl(IBuyDAO buyDAO){
        this.buyDAO = buyDAO;
    }

    @Override
    public void addBuy(Buy buy){
        Buy buyFromDb = this.buyDAO.getBuy(buy.getIdBuy());
        if(buyFromDb == null){
            this.buyDAO.addBuy(buy);
        }
    }


}
