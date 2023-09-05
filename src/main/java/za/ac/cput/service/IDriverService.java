package za.ac.cput.service;

import za.ac.cput.domain.Driver;

import java.util.Set;

public interface IDriverService extends IService<Driver, String>{

    Driver create (Driver driver);

    @Override
    boolean delete(String Id);

    public Set<Driver> getAll();
}
