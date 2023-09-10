package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.util.Set;

public interface IProductService extends IService<Product, String>{
    Set<Product> getAll();


}

