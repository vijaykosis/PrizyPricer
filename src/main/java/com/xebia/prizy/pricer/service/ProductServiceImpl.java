package com.xebia.prizy.pricer.service;

import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProductList = new ArrayList<>();
        Iterator<Product> allProductsItr = productRepo.findAll().iterator();
        while (allProductsItr.hasNext()) {
            Product product = (Product) allProductsItr.next();
            allProductList.add(product);
        }
        return allProductList;
    }

}
