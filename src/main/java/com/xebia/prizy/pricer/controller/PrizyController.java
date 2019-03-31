package com.xebia.prizy.pricer.controller;

import java.util.List;
import java.util.Optional;

import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.model.ProductViewer;
import com.xebia.prizy.pricer.model.SurveyProduct;
import com.xebia.prizy.pricer.service.ProductService;
import com.xebia.prizy.pricer.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrizyController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    ProductService productService;

    @RequestMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/product/readProduct")
    public Optional<Product> getProductById(@RequestParam(value = "id") long id) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            return product;
        }
        return null;
    }

    @PostMapping(path = "/product/createProduct", consumes = "application/json", produces = "application/json")
    public String addProduct(@RequestBody Product Product) {
        return productService.saveProduct(Product);
    }

    @RequestMapping("/product/readProductByCode")
    public ProductViewer getProductByCode(@RequestParam(value = "id") int barCode) {
        return surveyService.getProductDetailsByBarId(barCode);
    }

    @RequestMapping("product/createSurvey")
    public String createSurveyProduct(@RequestBody SurveyProduct surveyProduct) {
        return surveyService.saveSurveyPrice(surveyProduct);
    }
}
