package com.xebia.prizy.pricer.util;

import com.xebia.prizy.pricer.model.SurveyProduct;
import com.xebia.prizy.pricer.service.ProductPriceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceUtil {

    public Double getFirstAndSecondLowestNumberSum(List<SurveyProduct> surveyProducts) {

        double first, second;

        first = second = Integer.MAX_VALUE;

        for (SurveyProduct surveyProduct : surveyProducts) {
            double price = surveyProduct.getPriceByUser();
            if (price < first) {
                second = first;
                first = price;
            }
            /* If arr[i] is in between first and second
               then update second  */
            else if (price < second && price != first)
                second = price;
        }
        return first + second;
    }


    public Double getFirstAndSecondHighestNumberSum(List<SurveyProduct> surveyProducts) {

        double i, firstLargest, secondLargest;

        firstLargest = secondLargest = Double.MIN_VALUE;
        for (SurveyProduct surveyProduct : surveyProducts) {
            double price = surveyProduct.getPriceByUser();

            /* If current element is smaller than first then update both first and second */
            if (price > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = price;
            }
            /* If arr[i] is in between first and
               second then update second  */
            else if (price > secondLargest && price != secondLargest)
                secondLargest = price;
        }
        return firstLargest + secondLargest;


    }

    public Double calculateTotalSum(List<SurveyProduct> surveyProducts) {
        return surveyProducts.stream().mapToDouble(x -> x.getPriceByUser()).sum();
    }
}
