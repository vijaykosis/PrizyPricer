package com.xebia.prizy.pricer.repository;

import com.xebia.prizy.pricer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByBarCode(String barCode);
}
