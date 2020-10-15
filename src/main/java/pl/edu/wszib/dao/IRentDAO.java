package pl.edu.wszib.dao;

import pl.edu.wszib.model.Rent;

public interface IRentDAO {
    void addRent(Rent rent);

    Rent getRent(int idRent);

    Rent removeRentId(int idRent);
}
