package pl.edu.wszib.dao;

import pl.edu.wszib.model.Buy;
import pl.edu.wszib.model.Rent;

public interface IBuyDAO {
    void addBuy(Buy buy);

    Buy getBuy(int idBuy);


    Buy removeBuyId(int idBuy);
}
