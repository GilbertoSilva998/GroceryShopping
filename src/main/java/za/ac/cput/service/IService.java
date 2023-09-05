package za.ac.cput.service;

public interface IService <S, ID>{
    S create (S s);
    S read (ID Id);
    S update (S s);
    boolean delete (ID Id);
}
