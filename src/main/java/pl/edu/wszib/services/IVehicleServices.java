package pl.edu.wszib.services;

import pl.edu.wszib.model.Vehicle;

public interface IVehicleServices {
    void addVehicle(Vehicle vehicle);

    Vehicle getVehicle(int idVehicle);

    void getUpdate(int idVehicle, Vehicle vehicle);

    void removeVehicleId(int idVehicle);
}
