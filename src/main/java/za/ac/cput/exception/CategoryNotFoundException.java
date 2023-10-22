package za.ac.cput.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(Long id){
        super("Could not find category wih id " +id);
    }
}
