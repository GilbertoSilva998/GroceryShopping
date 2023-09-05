package za.ac.cput.repository;

import za.ac.cput.domain.Driver;

import java.util.HashSet;
import java.util.Set;

/**
 * DriverRepository.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

public class DriverRepository implements IDriverRepository{

    private static DriverRepository driverRepository = null;

    private Set<Driver> driverSet = null;
    private DriverRepository (){driverSet = new HashSet<Driver>();}

    public static DriverRepository getRepository(){
        if(driverRepository == null){
            driverRepository = new DriverRepository();
        }
        return driverRepository;
    }

    @Override
    public Set<Driver> getAll() {
        return driverSet;
    }

    @Override
    public Driver create(Driver driver) {
        boolean success = driverSet.add(driver);
        if (!success)
            return null;
        return driver;
    }

    @Override
    public Driver read(String driver_ID) {
        Driver driver = driverSet.stream()
                .filter(s -> s.getDriver_ID().equals(driver_ID))
                .findAny()
                .orElse(null);
        return driver;
    }

    @Override
    public Driver update(Driver driver) {
        Driver oldDriver = read(driver.getDriver_ID());
        if (oldDriver != null){
            driverSet.remove(oldDriver);
            driverSet.add(driver);
            return driver;
        }
        return null;
    }

    @Override
    public boolean delete(String driver_ID) {
        Driver deleteDriver = read(driver_ID);
        if (deleteDriver == null)
            return false;
        driverSet.remove(deleteDriver);
        return true;
    }
}
