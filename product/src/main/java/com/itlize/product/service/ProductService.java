package com.itlize.product.service;

import com.itlize.product.dataobject.ProductInfo;

import java.util.List;


public interface ProductService {


    List<ProductInfo> findUpAll();

    /*find the product list */

    List<ProductInfo> findList(List<String> productIdList);
}
