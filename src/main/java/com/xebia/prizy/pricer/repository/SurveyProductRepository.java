package com.xebia.prizy.pricer.repository;

import com.xebia.prizy.pricer.model.Product;
import com.xebia.prizy.pricer.model.SurveyProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyProductRepository extends CrudRepository<SurveyProduct, Long> {

    List<SurveyProduct> findByProductBarCode(int barCode);

}
