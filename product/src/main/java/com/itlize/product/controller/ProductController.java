package com.itlize.product.controller;

import com.itlize.product.DTO.CartDTO;
import com.itlize.product.VO.ProductInfoVO;
import com.itlize.product.VO.ProductVO;
import com.itlize.product.VO.ResultVO;
import com.itlize.product.dataobject.ProductCategory;
import com.itlize.product.dataobject.ProductInfo;
import com.itlize.product.repository.ProductInfoRepository;
import com.itlize.product.service.CategoryService;
import com.itlize.product.service.ProductService;
import com.itlize.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
        * 1. Check all the products on the shelf
          * 2. Get the category type list
          * 3. Query category
          * 4. Structure data
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        //1. Check all the products on the shelf
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. Get category type list
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. Query category from database
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4. Construct data
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }



    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }
}
