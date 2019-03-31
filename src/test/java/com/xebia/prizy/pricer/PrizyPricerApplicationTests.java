package com.xebia.prizy.pricer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.xebia.prizy.pricer.model.SurveyProduct;
import com.xebia.prizy.pricer.service.ProductPrice;
import com.xebia.prizy.pricer.service.ProductPriceImpl;
import com.xebia.prizy.pricer.util.PriceUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PriceUtil.class)
@ComponentScan(basePackages = "com.xebia.*")
public class PrizyPricerApplicationTests {

    private static List<SurveyProduct> surveyProducts = new ArrayList<>();


    @Autowired
    PriceUtil priceUtil;


    @BeforeClass
    public static void setup() {
        SurveyProduct surveyProduct1 = new SurveyProduct();
        SurveyProduct surveyProduct2 = new SurveyProduct();
        SurveyProduct surveyProduct3 = new SurveyProduct();
        SurveyProduct surveyProduct4 = new SurveyProduct();
        SurveyProduct surveyProduct5 = new SurveyProduct();
        SurveyProduct surveyProduct6 = new SurveyProduct();
        SurveyProduct surveyProduct7 = new SurveyProduct();
        SurveyProduct surveyProduct8 = new SurveyProduct();
        surveyProduct1.setPriceByUser(5);
        surveyProduct2.setPriceByUser(2);
        surveyProduct3.setPriceByUser(30);
        surveyProduct4.setPriceByUser(70);
        surveyProduct5.setPriceByUser(50);
        surveyProduct6.setPriceByUser(20);
        surveyProduct7.setPriceByUser(10);
        surveyProduct8.setPriceByUser(20);
        surveyProducts.add(surveyProduct8);
        surveyProducts.add(surveyProduct7);
        surveyProducts.add(surveyProduct6);
        surveyProducts.add(surveyProduct5);
        surveyProducts.add(surveyProduct4);
        surveyProducts.add(surveyProduct3);
        surveyProducts.add(surveyProduct2);
        surveyProducts.add(surveyProduct1);
    }


    @Test
    public void testFindAndSecondHigehstSum() {
        double highPrice = priceUtil.getFirstAndSecondHighestNumberSum(surveyProducts);
        assertEquals(120, highPrice, 0);
    }

    @Test
    public void testFindIdealPrice() {
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
        assertEquals(84.9, idealPrice, 0);
    }

    @Test
    public void testFindAndSecondLopwestSum() {
        double highPrice = priceUtil.getFirstAndSecondLowestNumberSum(surveyProducts);
        assertEquals(7.0, highPrice, 0);
    }

}
