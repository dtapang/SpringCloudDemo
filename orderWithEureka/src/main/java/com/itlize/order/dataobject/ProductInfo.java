package com.itlize.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yang shu
 * 2019-12-09 21:23
 */
@Data
//@Table(name = "T_proxxx")
@Entity
public class ProductInfo {

    @Id
    private String productId;


    private String productName;

    private BigDecimal productPrice;


    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** Status, 0 normal 1 off the shelf. */
    private Integer productStatus;


    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
