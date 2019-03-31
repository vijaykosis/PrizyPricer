package com.xebia.prizy.pricer.service;

import com.xebia.prizy.pricer.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();

    public Optional<Product> getProductById(long id);
}