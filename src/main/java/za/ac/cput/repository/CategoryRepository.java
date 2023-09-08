/**
 * CategoryReposotory.java
 * This is a CategoryRepository class for Category
 * @author Sinentlahla Pindani 219081328
 * 08 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryRepository implements ICategoryRepository {
    private static CategoryRepository repository = null;
    private Set<Category> categoryDB = null;
    private CategoryRepository(){
        categoryDB = new HashSet<Category>();
    }
    public static CategoryRepository getRepository(){
        if (repository == null){repository = new CategoryRepository();}
        return repository;
    }

    @Override
    public Category create(Category category){
        boolean success = categoryDB.add(category);
        if (!success)
            return null;
        return category;
    }

    @Override
    public Category read(String categoryId){
        Category category= categoryDB.stream()
                .filter( e -> e.getCategoryId().equals(categoryId))
                .findAny()
                .orElse(null);
        return category;
    }
    @Override
    public Category update(Category category) {
        Category oldcategory =read(category.getCategoryId());
        if(oldcategory!= null) {
            categoryDB.remove(oldcategory);
            categoryDB.add(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(String categoryId){
        Category categoryToDelete = read(categoryId);
        if(categoryToDelete == null)
            return false;
        categoryDB.remove(categoryToDelete);

        return true;
    }

    @Override
    public Set<Category> getAll(){
        return categoryDB;
    }


}
