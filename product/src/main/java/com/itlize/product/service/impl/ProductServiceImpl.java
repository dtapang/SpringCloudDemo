package com.itlize.product.service.impl;

import com.itlize.product.dataobject.ProductInfo;
import com.itlize.product.enums.ProductStatusEnum;
import com.itlize.product.repository.ProductInfoRepository;
import com.itlize.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang shu
 * 2017-12-09 21:59
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public  List<ProductInfo> findList(List<String> productIdList){
        return productInfoRepository.findByProductIdIn(productIdList);
    }
}
