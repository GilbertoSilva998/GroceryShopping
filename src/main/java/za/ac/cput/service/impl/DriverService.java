package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Driver;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.IDriverRepository;
import za.ac.cput.service.IDriverService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService implements IDriverService {

    private final IDriverRepository driverRepository;

    @Autowired
    private DriverService(IDriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }


    @Override
    public Driver create(Driver driver) {
        return this.driverRepository.save(driver);
    }

    @Override
    public Driver read(String driver_ID) {
        return this.driverRepository.findById(driver_ID).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if (this.driverRepository.existsById(driver.getDriver_ID())) {
            return this.driverRepository.save(driver);

        }
        return null;
    }

    @Override
    public boolean delete(String driver_ID) {
        if (this.driverRepository.existsById(driver_ID)) {
            this.driverRepository.deleteById(driver_ID);
            return true;
        }
        return false;
    }

    @Override
    public List<Driver> getAll() {
        return this.driverRepository.findAll().stream().collect(Collectors.toList());
    }
}
