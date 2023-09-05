package za.ac.cput.controller;

import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.impl.DriverService;
import java.util.Set;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)

    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver) {
        Driver driverCreated = DriverFactory.createDriver(driver.getDriver_ID(), driver.getFirst_Name(), driver.getLast_Name(), driver.getDriver_License_Number(), driver.getVehicle_Information(), driver.getPhone_Number(), driver.getEmail()/*"Gilberto","3e91930239","0623108129","vjvjyjv"*/);
        return driverService.create(driver);
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

    @GetMapping({"/getall"})
        public Set<Driver> getall(){
        return driverService.getAll();
    }

}
