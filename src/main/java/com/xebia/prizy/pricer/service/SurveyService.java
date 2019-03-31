package com.xebia.prizy.pricer.service;

import com.xebia.prizy.pricer.model.ProductViewer;
import com.xebia.prizy.pricer.model.SurveyProduct;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SurveyService {
    String saveSurveyPrice(SurveyProduct surveyProduct);
    ProductViewer getProductDetailsByBarId(int barCode);
    List<SurveyProduct> getAllSurvey();
}
