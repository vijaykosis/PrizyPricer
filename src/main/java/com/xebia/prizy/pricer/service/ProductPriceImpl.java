package com.xebia.prizy.pricer.service;

import com.xebia.prizy.pricer.model.SurveyProduct;
import com.xebia.prizy.pricer.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component("productPriceImpl")
public class ProductPriceImpl implements ProductPrice {

    @Autowired
    private PriceUtil priceUtil;

    @Override
    public double findProductIdealPrice(List<SurveyProduct> surveyProducts) {

        Double highestNumberSum = priceUtil.getFirstAndSecondHighestNumberSum(surveyProducts);
        Double lowestNumberSum = priceUtil.getFirstAndSecondLowestNumberSum(surveyProducts);
        Double totalSum = priceUtil.calculateTotalSum(surveyProducts);
        Double idealPrice;
        int totalSize = surveyProducts.size();
        if (totalSize > 4) {
            // Removing highest 2 and lowest 2 number
            // Also add  20%
            idealPrice = totalSum - highestNumberSum - lowestNumberSum / (surveyProducts.size() - 4) * 1.2;
        } else {
            // add 20%
            idealPrice = (totalSum / totalSize) * 1.2;
        }
        return idealPrice;
    }
}
