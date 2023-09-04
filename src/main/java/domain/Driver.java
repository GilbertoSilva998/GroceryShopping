package domain;

/**
 * Driver.java
 * @author: Gilberto Silva (218239300)
 * Date: 07 April 2023
 */
public class Driver {
    private String driver_ID;
    private String first_Name;
    private String last_Name;
    private int driver_License_Number;
    private String vehicle_Information;
    private long phone_Number;
    private String email;

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

    public void setDriver_ID(String driver_ID) {this.driver_ID = driver_ID;}

    public String getFirst_Name() {return first_Name;}

    public void setFirst_Name(String first_Name) {this.first_Name = first_Name;}

    public String getLast_Name() {return last_Name;}


    public void setLast_Name(String last_Name) {this.last_Name = last_Name;}

    public int getDriver_License_Number() {return driver_License_Number;}

    public void setDriver_License_Number(int driver_License_Number) {this.driver_License_Number = driver_License_Number;}

    public String getVehicle_Information() {return vehicle_Information;}

    public void setVehicle_Information(String vehicle_Information) {this.vehicle_Information = vehicle_Information;}

    public long getPhone_Number() {return phone_Number;}

    public void setPhone_Number(long phone_Number) {this.phone_Number = phone_Number;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

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
        private int driver_License_Number;
        private String vehicle_Information;
        private long phone_Number;
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

        public Builder setDriver_License_Number(int driver_License_Number){
            this.driver_License_Number = driver_License_Number;
            return this;
        }

        public Builder setVehicle_Information(String vehicle_Information){
            this.vehicle_Information = vehicle_Information;
            return this;
        }

        public Builder setPhone_Number(long phone_Number){
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
