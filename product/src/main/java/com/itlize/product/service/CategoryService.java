package com.itlize.product.service;

import com.itlize.product.dataobject.ProductCategory;

import java.util.List;


public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
