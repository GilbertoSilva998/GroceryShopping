package za.ac.cput.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id){
        super("Could not find customer wih id " +id);
    }
}
