/**
 * IRepository.java
 * This is the main repository interface for all repository classes
 * @author Asive Sibeko 219475296(Group lead)
 * 08 April 2023
 */

package za.ac.cput.repository;

public interface IRepository<T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID Id);
}
