package pl.edu.wszib.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;
    private String name;
    private String surname;
    private char pesel;
    private String phoneNumber;
    private String email;
    private int idUserApp;
    private char jobPosition;


    public Employee(int idEmployee, String name, String surname, char pesel, String phoneNumber, String email, int idUserApp, char jobPosition) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idUserApp = idUserApp;
        this.jobPosition = jobPosition;
    }

    public Employee(){

    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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

    public char getPesel() {
        return pesel;
    }

    public void setPesel(char pesel) {
        this.pesel = pesel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUserApp() {
        return idUserApp;
    }

    public void setIdUserApp(int idUserApp) {
        this.idUserApp = idUserApp;
    }

    public char getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(char jobPosition) {
        this.jobPosition = jobPosition;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel=" + pesel +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", idUserApp=" + idUserApp +
                ", jobPosition=" + jobPosition +
                '}';
    }
}
