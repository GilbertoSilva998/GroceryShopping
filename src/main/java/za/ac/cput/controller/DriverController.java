package za.ac.cput.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.impl.DriverService;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin("http://localhost:3000")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver) {
        Driver newDriver = DriverFactory.createDriver(driver.getFirst_Name(),driver.getLast_Name(),
                driver.getDriver_License_Number(), driver.getVehicle_Information(), driver.getPhone_Number(),driver.getEmail());
        return driverService.create(newDriver);
    }
    @GetMapping("/read/{id}")
    public Driver read (@PathVariable String id){
        return driverService.read(id);
    }

    @PostMapping("/update")
        public Driver update (@RequestBody Driver driver){
            return driverService.update(driver);
        }


    @DeleteMapping ("delete/{id}")
        public boolean delete (@PathVariable String id) {
            return driverService.delete(id);
        }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping({"/getall"})
        public List<Driver> getall(){
        return driverService.getAll();
    }

}
