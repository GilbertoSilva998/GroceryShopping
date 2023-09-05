package za.ac.cput.repository;

/**
 * IDriverService.java
 * @author: Gilberto Silva (218239300)
 * Date: 08 April 2023
 */

import za.ac.cput.domain.Driver;

import java.util.Set;

public interface IDriverRepository extends IRepository <Driver, String>{
    public Set<Driver> getAll();
    //private Set<Driver> driverDB;

    /*public  DriverRepository (){
        driverDB = new HashSet<Driver>();

    } */

}
