package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IVehicleDao;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public class VehicleDAOImplStub implements IVehicleDao {
    @Override
    public void addVehicle(Vehicle vehicle) {

    }

    @Override
    public Vehicle getVehicle(int idVehicle) {
        return null;
    }

    @Override
    public Vehicle getUpdate(int idVehicle, Vehicle vehicle) {
        return null;
    }

    @Override
    public void updateVehicle(int idVehicle, Vehicle vehicle) {

    }

    @Override
    public Vehicle removeVehicleId(int idVehicle) {
        return null;
    }

    @Override
    public List<Vehicle> getAllCars() {
        return null;
    }

    @Override
    public List<Vehicle> getAllMotorBike() {
        return null;
    }

    @Override
    public List<Vehicle> getAllBike() {
        return null;
    }

    @Override
    public List<Vehicle> getAllScooter() {
        return null;
    }
}
