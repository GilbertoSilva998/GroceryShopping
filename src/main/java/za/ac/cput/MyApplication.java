package za.ac.cput;

import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DriverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.impl.DriverService;

@RestController
@SpringBootApplication
public class MyApplication {

    @Autowired
    private DriverService driverService;

    @RequestMapping({"/", "/home"})
    String home() {
        return "Saluton mondo!";
    }

     @RequestMapping(value = "/create", method = RequestMethod.POST)

    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver)
    {
        Driver driverCreated = DriverFactory.createDriver(driver.getDriver_ID(),
                driver.getFirst_Name(),
                driver.getLast_Name(),
                driver.getDriver_License_Number(),
                driver.getVehicle_Information(),
                driver.getPhone_Number(),
                driver.getEmail());

        return driverService.create(driver);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
