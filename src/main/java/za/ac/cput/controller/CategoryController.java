package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.service.impl.CategoryService;

import java.util.List;
@RestController
@RequestMapping("/category")
//@CrossOrigin("http://localhost:3000")
public class CategoryController {
    @Autowired
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
    }




}
