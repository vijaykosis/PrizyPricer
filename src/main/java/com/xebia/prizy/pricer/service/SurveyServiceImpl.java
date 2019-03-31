package com.xebia.prizy.pricer.service;

import com.xebia.prizy.pricer.constant.MessageType;
import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.model.ProductViewer;
import com.xebia.prizy.pricer.model.SurveyProduct;
import com.xebia.prizy.pricer.repository.ProductRepository;
import com.xebia.prizy.pricer.repository.SurveyProductRepository;
import com.xebia.prizy.pricer.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SurveyProductRepository surveyProductRepository;

    @Autowired
    @Qualifier("productPriceImpl")
    private ProductPrice productPrice;

    @Autowired
    private PriceUtil priceUtil;


    @Override
    public String saveSurveyPrice(SurveyProduct surveyProduct) {
        SurveyProduct survey = surveyProductRepository.save(surveyProduct);
        if (survey != null) {
            return MessageType.SUCCESS_MESSAGE.getMessageType();
        }
        return MessageType.UNSUCCESS_MESSAGE.getMessageType();
    }

    @Override
    public ProductViewer getProductDetailsByBarId(int barCode) {
        ProductViewer productViewer = new ProductViewer();
        Product product = productRepository.findProductByBarCode(barCode);
        if (product != null) {
            List<SurveyProduct> allSurveyProducts = surveyProductRepository.findByProductBarCode(barCode);
            int noOfSurveys = allSurveyProducts.size();
            if (noOfSurveys != 0) {

                double highPrice = priceUtil.getFirstAndSecondHighestNumberSum(allSurveyProducts);
                double lowPrice = priceUtil.getFirstAndSecondLowestNumberSum(allSurveyProducts);
                double idealPrice = productPrice.findProductIdealPrice(allSurveyProducts);
                double totalSum = priceUtil.calculateTotalSum(allSurveyProducts);
                double avgPrice = totalSum / noOfSurveys;

                productViewer.setAvgPrice(avgPrice);
                productViewer.setIdealPrice(idealPrice);
                productViewer.setLowestPrice(lowPrice);
                productViewer.setHighestPrice(highPrice);
                productViewer.setNoOfPrices(noOfSurveys);
            } else {
                productViewer.setInstructions("Please take some survey first");
            }
            productViewer.setBarCode(product.getBarCode());
            productViewer.setDescription(product.getDiscription());
        } else {
            productViewer.setInstructions("No Product with Bar code : " + barCode);
        }

        return productViewer;

    }
}