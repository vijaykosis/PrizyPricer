package com.xebia.prizy.pricer.controller;

import java.util.List;

import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrizyController {


    @Autowired
    ProductService productService;

    @RequestMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
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
