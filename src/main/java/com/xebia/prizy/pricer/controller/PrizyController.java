package com.xebia.prizy.pricer.controller;

import java.util.List;
import java.util.Optional;

import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrizyController {


    @Autowired
    ProductService productService;

    @RequestMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/product")
    public Optional<Product> getProduct(@RequestParam(value = "id") long id) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            return product;
        }
        return null;
    }


    /*@RequestMapping("/product")
    public ProductVO getProduct(@RequestParam(value = "code") String barCode) {
        return productSurveyService.getProductDetails(barCode);
    }

    @RequestMapping("/submitSurvey")
    public String submitSurveyProduct(@RequestBody SurveyProduct surveyProduct) {
        return productSurveyService.submitSurveyPrice(surveyProduct);
    }
*/
}
