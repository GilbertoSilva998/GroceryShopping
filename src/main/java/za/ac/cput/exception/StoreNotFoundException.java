package za.ac.cput.exception;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(Long id){
        super("Could not find the store wih id " +id);
    }
}
