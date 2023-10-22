package za.ac.cput.exception;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(Long id){
        super("Could not find the driver wih id " +id);
    }
}
