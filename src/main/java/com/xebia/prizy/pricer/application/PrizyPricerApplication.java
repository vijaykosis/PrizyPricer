package com.xebia.prizy.pricer.application;

import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.model.SurveyProduct;
import com.xebia.prizy.pricer.repository.ProductRepository;
import com.xebia.prizy.pricer.repository.SurveyProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.xebia.*")
@EnableJpaRepositories(basePackageClasses = {ProductRepository.class, SurveyProductRepository.class})
@EntityScan(basePackageClasses = {Product.class, SurveyProduct.class})
public class PrizyPricerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrizyPricerApplication.class, args);
    }
}
