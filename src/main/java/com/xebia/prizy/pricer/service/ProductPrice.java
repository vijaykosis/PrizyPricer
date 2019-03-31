package com.xebia.prizy.pricer.service;

import com.xebia.prizy.pricer.model.SurveyProduct;
import java.util.List;

public interface ProductPrice {

    double findProductIdealPrice(List<SurveyProduct> surveyProducts);
}
