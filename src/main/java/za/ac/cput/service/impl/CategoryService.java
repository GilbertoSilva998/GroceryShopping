package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.ICategoryRepository;
import za.ac.cput.service.ICategoryService;

import java.util.List;


@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository repository;
    @Autowired
    private CategoryService(ICategoryRepository repository){
        this.repository=repository;

    }


    @Override
    public Category create(Category category) {
        return this.repository.save(category);
    }

    @Override
    public Category read(String categoryId) {
        return this.repository.findById(categoryId).orElse(null);
    }

    @Override
    public Category update(Category category) {
        if( this.repository.existsById(category.getCategoryId()))
            return this.repository.save(category);
        return null;
    }

    @Override
    public boolean delete(String categoryId) {
        if (this.repository.existsById(categoryId)){
            this.repository.deleteById(categoryId);
            return true;
        }
        return false;
    }
    @Override
    public List<Category> getAll() {
        return this.repository.findAll();
    }

}
