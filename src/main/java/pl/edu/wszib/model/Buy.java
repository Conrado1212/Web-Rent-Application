package pl.edu.wszib.model;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Buy {
    private int idBuy;
    private int idVehicle;
    private int idCustomer;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;


    public Buy(){

    }

    public Buy(int idBuy, int idVehicle, int idCustomer, String ccNumber, String ccExpiration, String ccCVV) {
        this.idBuy = idBuy;
        // @NotBlank(message="idCustomer is required")
        this.idVehicle = idVehicle;
        // @NotBlank(message="idCustomer is required")
        this.idCustomer = idCustomer;
        // @CreditCardNumber(message="Not a valid credit card number")
        this.ccNumber = ccNumber;
        // @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
        // message="Must be formatted MM/YY")
        this.ccExpiration = ccExpiration;
        // @Digits(integer=3, fraction=0, message="Invalid CVV")
        this.ccCVV = ccCVV;
    }

    public int getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(int idBuy) {
        this.idBuy = idBuy;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }


    @Override
    public String toString() {
        return "Buy{" +
                "idBuy=" + idBuy +
                ", idVehicle=" + idVehicle +
                ", idCustomer=" + idCustomer +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccExpiration='" + ccExpiration + '\'' +
                ", ccCVV='" + ccCVV + '\'' +
                '}';
    }

    // @Size(min=1, message="Each order must contain at least 1 design of Buy")
    private List<Buy> buys = new ArrayList<>();
}
