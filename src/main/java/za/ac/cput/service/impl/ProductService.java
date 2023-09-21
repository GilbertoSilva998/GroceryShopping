package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.IProductRepository;
import za.ac.cput.service.IProductService;

import java.util.Set;
@Service
public class ProductService implements IProductService {
    private static IProductRepository repository;

    @Autowired
    private ProductService(IProductRepository repository){
        this.repository = repository;

    }

    public static ProductService getService() {
        return null;
    }


    @Override
    public Product create(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product read(String productId) {
        return this.repository.findById(productId).orElse(null);
    }

    @Override
    public Product update(Product product) {
        if (this.repository.existsById(product.getProductId()))
            return this.repository.save(product);
        return null;
    }

    @Override
    public boolean delete(String productId) {
        if (this.repository.existsById(productId)){
            this.repository.deleteById(productId);
            return true;

        }
        return false;
    }
    @Override
    public Set<Product> getAll() {

        return (Set<Product>) this.repository.findAll();
    }
}
