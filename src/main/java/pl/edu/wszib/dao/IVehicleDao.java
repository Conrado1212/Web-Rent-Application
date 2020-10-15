package pl.edu.wszib.dao;

import pl.edu.wszib.model.Vehicle;

public interface IVehicleDao {
    void addVehicle(Vehicle vehicle);

    Vehicle getVehicle(int idVehicle);

    Vehicle getUpdate(int idVehicle, Vehicle vehicle);


    void updateVehicle(int idVehicle, Vehicle vehicle);

    Vehicle removeVehicleId(int idVehicle);

    java.util.List<Vehicle> getAllCars();

    java.util.List<Vehicle> getAllMotorBike();

    java.util.List<Vehicle> getAllBike();

    java.util.List<Vehicle> getAllScooter();
}
