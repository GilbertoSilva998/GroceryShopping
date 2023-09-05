package za.ac.cput.service.impl;

import za.ac.cput.domain.Driver;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.DriverRepository;
import za.ac.cput.service.IDriverService;

import java.util.Set;

@Service
public class DriverService implements IDriverService {

    private static DriverService driverService = null;

    private static DriverRepository driverRepository = null;

    private DriverService(){driverRepository = DriverRepository.getRepository();}

    public static DriverService getDriverService(){
        if (driverService == null) {
            driverService = new DriverService();
        }
        return driverService;
    }
    @Override
    public Driver create(Driver driver) {
        Driver created = driverRepository.create(driver);
        return created;
    }

    @Override
    public Driver read(String driver_ID) {
        Driver readed = driverRepository.read(driver_ID);
        return readed;
    }

    @Override
    public Driver update(Driver driver) {
        Driver updated = driverRepository.update(driver);
        return null;
    }

    @Override
    public boolean delete(String driver_ID) {
        boolean deleted = driverRepository.delete(driver_ID);
        return deleted;
    }

    @Override
    public Set<Driver> getAll() {
        return null;
    }
}
