package za.ac.cput.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not find user wih id " +id);
    }
}
