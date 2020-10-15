package pl.edu.wszib.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int idUserApp;
    private Point location;
    private String locationName;
    private Polygon border;

    public Customer(int idCustomer, String name, String surname, String email, String phone, int idUserApp, Point location, String locationName, Polygon border) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.idUserApp = idUserApp;
        this.location = location;
        this.locationName = locationName;
        this.border = border;
    }

    public Customer(){

    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdUserApp() {
        return idUserApp;
    }

    public void setIdUserApp(int idUserApp) {
        this.idUserApp = idUserApp;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Polygon getBorder() {
        return border;
    }

    public void setBorder(Polygon border) {
        this.border = border;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", idUserApp=" + idUserApp +
                ", location=" + location +
                ", locationName='" + locationName + '\'' +
                ", border=" + border +
                '}';
    }
}
