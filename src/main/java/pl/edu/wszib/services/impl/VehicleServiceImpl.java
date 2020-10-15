package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IVehicleDao;
import pl.edu.wszib.model.Vehicle;
import pl.edu.wszib.services.IVehicleServices;

public class VehicleServiceImpl implements IVehicleServices {

    @Autowired
    IVehicleDao vehicleDao;

    public VehicleServiceImpl(IVehicleDao vehicleDao){
        this.vehicleDao = vehicleDao;
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        Vehicle vehicleFromDb = this.vehicleDao.getVehicle(vehicle.getIdVehicle());
        if(vehicleFromDb == null){
            this.vehicleDao.addVehicle(vehicle);
        }
    }

    @Override
    public Vehicle getVehicle(int idVehicle){
        return this.vehicleDao.getVehicle(idVehicle);
    }

    @Override
    public void getUpdate(int idVehicle,Vehicle vehicle){
        Vehicle vehicleFromDb = this.vehicleDao.getUpdate(idVehicle,vehicle);
        if(vehicleFromDb == null){
            this.vehicleDao.getUpdate(idVehicle,vehicle);
        }
    }

    @Override
    public void removeVehicleId(int idVehicle){
        Vehicle vehicleFromDb = this.vehicleDao.removeVehicleId(idVehicle);
        if(vehicleFromDb == null){
            this.vehicleDao.removeVehicleId(idVehicle);
        }
    }
}
