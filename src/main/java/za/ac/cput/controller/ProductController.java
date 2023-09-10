package za.ac.cput.controller;

import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.IProductService;
import java.util.Set;


@RestController
@RequestMapping("/product")
public class ProductController {

    private IProductService productService;
    @Autowired
    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        Product newProduct = ProductFactory.createProduct(product.getProductNum(), product.getProductType(), product.getProductItem(), product.getProductDescription());
        return productService.create(newProduct);
    }
    @GetMapping("/read/{id}")
    Product read(@PathVariable String ProductId){
        return productService.read(ProductId);
    }
    @PostMapping("/update")
    Product update(@RequestBody  Product product){
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable String productId){
        return productService.delete(productId);
    }
    @GetMapping("/all")
    Set<Product> getAll(){
        return productService.getAll();
    }
}
