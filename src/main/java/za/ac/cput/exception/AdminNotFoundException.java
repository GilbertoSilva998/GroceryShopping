package za.ac.cput.exception;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(Long id){
        super("Could not find admin wih id " +id);
    }
}
