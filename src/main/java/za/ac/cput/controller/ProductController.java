package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.exception.ProductNotFoundException;
import za.ac.cput.repository.IProductRepository;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @PostMapping("/product")
    Product newProduct(@RequestBody Product newProduct){
        return productRepository.save(newProduct);
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable Long id){
        return productRepository.findById(String.valueOf(id))
                .orElseThrow(()->new ProductNotFoundException(id));
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return productRepository.findById(String.valueOf(id))
                .map(product -> {
                    product.setProductNum(newProduct.getProductNum());
                    product.setProductType(newProduct.getProductType());
                    product.setProductItem(newProduct.getProductItem());
                    product.setProductDescription(newProduct.getProductDescription());
                    return productRepository.save(product);
                }).orElseThrow(()->new ProductNotFoundException(id));
    }

    @DeleteMapping("/product/{id}")
    String deleteProduct(@PathVariable Long id){
        if (!productRepository.existsById(String.valueOf(id))){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(String.valueOf(id));
        return "Product with id " +id+ " has been deleted successfully.";
    }
    
    /* @Autowired
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
    } */


}
