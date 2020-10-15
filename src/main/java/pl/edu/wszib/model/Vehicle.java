package pl.edu.wszib.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehicle;
    private int idGroupVehicle;
    private String brand;
    private String model;
    private int maxRange;
    private int weight;
    private double pricePerSale;
    private int maxSpeed;
    private Point locationVehicle;
    private String nameLocation;
    private Polygon borderVehicle;

    public Vehicle(){

    }

    public Vehicle(int idVehicle, int idGroupVehicle, String brand, String model, int maxRange, int weight, double pricePerSale, int maxSpeed, Point locationVehicle, String nameLocation, Polygon borderVehicle) {
        this.idVehicle = idVehicle;
        this.idGroupVehicle = idGroupVehicle;
        this.brand = brand;
        this.model = model;
        this.maxRange = maxRange;
        this.weight = weight;
        this.pricePerSale = pricePerSale;
        this.maxSpeed = maxSpeed;
        this.locationVehicle = locationVehicle;
        this.nameLocation = nameLocation;
        this.borderVehicle = borderVehicle;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getIdGroupVehicle() {
        return idGroupVehicle;
    }

    public void setIdGroupVehicle(int idGroupVehicle) {
        this.idGroupVehicle = idGroupVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPricePerSale() {
        return pricePerSale;
    }

    public void setPricePerSale(double pricePerSale) {
        this.pricePerSale = pricePerSale;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Point getLocationVehicle() {
        return locationVehicle;
    }

    public void setLocationVehicle(Point locationVehicle) {
        this.locationVehicle = locationVehicle;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public Polygon getBorderVehicle() {
        return borderVehicle;
    }

    public void setBorderVehicle(Polygon borderVehicle) {
        this.borderVehicle = borderVehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "idVehicle=" + idVehicle +
                ", idGroupVehicle=" + idGroupVehicle +
                ", brand=" + brand +
                ", model=" + model +
                ", maxRange=" + maxRange +
                ", weight=" + weight +
                ", pricePerSale=" + pricePerSale +
                ", maxSpeed=" + maxSpeed +
                ", locationVehicle=" + locationVehicle +
                ", nameLocation='" + nameLocation + '\'' +
                ", borderVehicle=" + borderVehicle +
                '}';
    }
}
