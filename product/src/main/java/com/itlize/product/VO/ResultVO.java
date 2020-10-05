package com.itlize.product.VO;

import lombok.Data;

/**
 * The outermost object returned by the http request
 * Created by yang shu
 * 2017-12-09 22:09
 */
@Data
public class ResultVO<T> {

    /**
     * Error code
     */
    private Integer code;

    /**
     * Prompt information
     */
    private String msg;

    /**
     * specific contents
     */
    private T data;
}
