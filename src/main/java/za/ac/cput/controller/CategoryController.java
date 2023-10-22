package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.exception.CategoryNotFoundException;
import za.ac.cput.repository.ICategoryRepository;

import java.util.List;
@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:3000")
public class CategoryController {
    @Autowired
    private ICategoryRepository categoryRepository;

    @PostMapping("/category")
    Category newCategory(@RequestBody Category newCategory){
        return categoryRepository.save(newCategory);
    }

    @GetMapping("/categories")
    List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    Category getCategoryById(@PathVariable Long id){
        return categoryRepository.findById(String.valueOf(id))
                .orElseThrow(()->new CategoryNotFoundException(id));
    }

    @PutMapping("/category/{id}")
    Category updateCategory(@RequestBody Category newCategory, @PathVariable Long id){
        return categoryRepository.findById(String.valueOf(id))
                .map(category -> {
                    category.setCategoryName(newCategory.getCategoryName());
                    category.setCategoryType(newCategory.getCategoryType());
                    return categoryRepository.save(category);
                }).orElseThrow(()->new CategoryNotFoundException(id));
    }

    @DeleteMapping("/category/{id}")
    String deleteCategory(@PathVariable Long id){
        if (!categoryRepository.existsById(String.valueOf(id))){
            throw new CategoryNotFoundException(id);
        }
        categoryRepository.deleteById(String.valueOf(id));
        return "Category with id " +id+ " has been deleted successfully.";
    }
    
    /** @Autowired
    private CategoryService categoryservice;

    @PostMapping("/create")
    public Category create(@RequestBody Category category){

        return categoryservice.create(category);
    }
    @GetMapping("/read/{id}")
    public Category read(@PathVariable String id){
        return categoryservice.read(id);
    }

    @PostMapping("/update")
    public Category update(@RequestBody Category category){

        return categoryservice.update(category);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return categoryservice.delete(id);
    }


    @GetMapping("/getall")
    public List<Category> getAll() {
        return  categoryservice.getAll();
    } **/




}
