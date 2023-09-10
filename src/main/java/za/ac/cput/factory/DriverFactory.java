package za.ac.cput.factory;

/**
 * DriverFactory.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */
import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

public class DriverFactory {
    public static Driver createDriver ( String first_Name, String last_Name, String driver_License_Number, String vehicle_Information, String phone_Number, String email){

        if (Helper.isNullorEmpty(first_Name) || Helper.isNullorEmpty(last_Name))
            return null;

        String driver_ID = Helper.generateId();

        if (!Helper.isValidEmail(email)){
            return null;
        }

        Driver driver = new Driver.Builder().setDriver_ID(driver_ID)
                .setFirst_Name(first_Name)
                .setLast_Name(last_Name)
                .setDriver_License_Number(driver_License_Number)
                .setVehicle_Information(vehicle_Information)
                .setPhone_Number(phone_Number)
                .setEmail(email)
                .build();
        return driver;
    }
}
