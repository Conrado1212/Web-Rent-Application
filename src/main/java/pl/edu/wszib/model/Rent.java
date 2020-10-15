package pl.edu.wszib.model;

public class Rent {
    private int idRent;
    private int idCustomer;
    private double price;
    private char status;


    public Rent(int idRent, int idCustomer, double price, char status) {
        this.idRent = idRent;
        this.idCustomer = idCustomer;
        this.price = price;
        this.status = status;
    }


    public Rent(){

    }

    public int getIdRent() {
        return idRent;
    }

    public void setIdRent(int idRent) {
        this.idRent = idRent;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "idRent=" + idRent +
                ", idCustomer=" + idCustomer +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
