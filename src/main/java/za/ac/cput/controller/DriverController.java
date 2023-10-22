package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Driver;
import za.ac.cput.exception.DriverNotFoundException;
import za.ac.cput.repository.IDriverRepository;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin("http://localhost:3000")
public class DriverController {

    @Autowired
    private IDriverRepository driverRepository;

    @PostMapping("/driver")
    Driver newDriver(@RequestBody Driver newDriver){
        return driverRepository.save(newDriver);
    }

    @GetMapping("/drivers")
    List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    @GetMapping("/driver/{id}")
    Driver getDriverById(@PathVariable Long id){
        return driverRepository.findById(String.valueOf(id))
                .orElseThrow(()->new DriverNotFoundException(id));
    }

    @PutMapping("/driver/{id}")
    Driver updateDriver(@RequestBody Driver newDriver, @PathVariable Long id){
        return driverRepository.findById(String.valueOf(id))
                .map(driver -> {
                    driver.setFirst_Name(newDriver.getFirst_Name());
                    driver.setLast_Name(newDriver.getLast_Name());
                    driver.setEmail(newDriver.getEmail());
                    driver.setPhone_Number(newDriver.getPhone_Number());
                    driver.setDriver_License_Number(newDriver.getDriver_License_Number());
                    driver.setVehicle_Information(newDriver.getVehicle_Information());
                    return driverRepository.save(driver);
                }).orElseThrow(()->new DriverNotFoundException(id));
    }

    @DeleteMapping("/driver/{id}")
    String deleteDriver(@PathVariable Long id){
        if (!driverRepository.existsById(String.valueOf(id))){
            throw new DriverNotFoundException(id);
        }
        driverRepository.deleteById(String.valueOf(id));
        return "Driver with id " +id+ " has been deleted successfully.";
    }

/**    @PostMapping("/create")
//    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
//        try {
//            Driver createdDriver = driverService.create(driver);
//            return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @RequestMapping("/create")
    public Driver create(@RequestBody Driver driver){
        Driver driver1 = DriverFactory.createDriver(driver.getFirst_Name(), driver.getLast_Name(), driver.getDriver_License_Number(), driver.getVehicle_Information(), driver.getPhone_Number(), driver.getEmail());
        return driverService.create(driver);
    }

//    @GetMapping("/read/{id}")
//    public ResponseEntity<Driver> read(@PathVariable String id) {
//        try {
//            Driver driver = driverService.read(id);
//            if (driver != null) {
//                return new ResponseEntity<>(driver, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/read/{id}")
    public Driver read(@PathVariable String id){

        return driverService.read(id);
    }


    @PostMapping("/update")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        try {
            Driver updatedDriver = driverService.update(driver);
            if (updatedDriver != null) {
                return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        try {
//            if (driverService.delete(id)) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @DeleteMapping("/delete/{id}")
//    String deleteDriver(@PathVariable Long id){
//        if (!driverRepository.existsById(id)) {
//            throw new DriverNo
//        }
//        driverRepository.deleteById(id);
//        return "Driver with id" +id+"has been delete";
//    }

    @GetMapping("/alldrivers")
    public List<Driver> getAll() {
            return driverService.getAll();
    }

//    GetMapping("/getall")
//    public ResponseEntity<List<Driver>> getAll() {
//        try {
//            List<Driver> drivers = driverService.getAll();
//            return new ResponseEntity<>(drivers, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    } */
}
