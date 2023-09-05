package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * Driver.java
 * @author: Gilberto Silva (218239300)
 * Date: 07 April 2023
 */

@Entity
public class Driver implements Serializable {
    private String driver_ID;
    private String first_Name;
    private String last_Name;
    private String driver_License_Number;
    private String vehicle_Information;
    private String phone_Number;
    private String email;

    @Id
    private Long id;


    //-----------Constructors--------------
    public Driver() {}

    //---------------Builder----------------
    private Driver(Builder builder){
        this.driver_ID = builder.driver_ID;
        this.first_Name = builder.first_Name;
        this.last_Name = builder.last_Name;
        this.driver_License_Number = builder.driver_License_Number;
        this.vehicle_Information = builder.vehicle_Information;
        this.phone_Number = builder.phone_Number;
        this.email = builder.email;
    }

    //------------Getters--------------
    public String getDriver_ID() {return driver_ID;}

    public String getFirst_Name() {return first_Name;}

    public String getLast_Name() {return last_Name;}

    public String getDriver_License_Number() {return driver_License_Number;}

    public String getVehicle_Information() {return vehicle_Information;}

    public String getPhone_Number() {return phone_Number;}

    public String getEmail() {
        return email;
    }

    public Long getId() {return id;}

    //------------Has Code -------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver driver)) return false;
        return Objects.equals(getDriver_ID(), driver.getDriver_ID()) && Objects.equals(getFirst_Name(), driver.getFirst_Name()) && Objects.equals(getLast_Name(), driver.getLast_Name()) && Objects.equals(getDriver_License_Number(), driver.getDriver_License_Number()) && Objects.equals(getVehicle_Information(), driver.getVehicle_Information()) && Objects.equals(getPhone_Number(), driver.getPhone_Number()) && Objects.equals(getEmail(), driver.getEmail()) && Objects.equals(getId(), driver.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriver_ID(), getFirst_Name(), getLast_Name(), getDriver_License_Number(), getVehicle_Information(), getPhone_Number(), getEmail(), getId());
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Long getId() {
        return id;
    }*/

    //------------To String ------------------
    @Override
    public String toString() {
        return "Driver{" +
                "driver_ID=" + driver_ID +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", driver_License_Number=" + driver_License_Number +
                ", vehicle_Information='" + vehicle_Information + '\'' +
                ", phone_Number=" + phone_Number +
                ", email='" + email + '\'' +
                '}';
    }
    //---------------Builder---------------------------
    public static class Builder{
        private String driver_ID;
        private String first_Name;
        private String last_Name;
        private String driver_License_Number;
        private String vehicle_Information;
        private String phone_Number;
        private String email;

        public Builder setDriver_ID(String driver_ID){
            this.driver_ID = driver_ID;
            return this;
        }

        public Builder setFirst_Name(String first_Name){
            this.first_Name = first_Name;
            return this;
        }

        public Builder setLast_Name(String last_Name){
            this.last_Name = last_Name;
            return this;
        }

        public Builder setDriver_License_Number(String driver_License_Number){
            this.driver_License_Number = driver_License_Number;
            return this;
        }

        public Builder setVehicle_Information(String vehicle_Information){
            this.vehicle_Information = vehicle_Information;
            return this;
        }

        public Builder setPhone_Number(String phone_Number){
            this.phone_Number = phone_Number;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder copy(Driver driver) {
            this.driver_ID = driver.driver_ID;
            this.first_Name = driver.first_Name;
            this.last_Name = driver.last_Name;
            this.driver_License_Number = driver.driver_License_Number;
            this.vehicle_Information = driver.vehicle_Information;
            this.phone_Number = driver.phone_Number;
            this.email = driver.email;
            return this;
        }

        public Driver build(){

            return new Driver(this);
        }

    }

}
