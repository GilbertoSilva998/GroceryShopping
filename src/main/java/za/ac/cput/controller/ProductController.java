package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.impl.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
//@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){

        return productService.create(product);
    }
    @GetMapping("/read/{id}")
    public Product read(@PathVariable String productId){
        return productService.read(productId);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product){

        return productService.update(product);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String productId){
        return productService.delete(productId);
    }


    @GetMapping("/getall")
    public List<Product> getAll() {
        return (List<Product>) productService.getAll();
    }


}
