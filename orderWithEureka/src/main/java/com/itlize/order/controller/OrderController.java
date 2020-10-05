package com.itlize.order.controller;

import com.itlize.order.VO.ResultVO;
import com.itlize.order.converter.OrderForm2OrderDTOConverter;
import com.itlize.order.dataobject.OrderMaster;
import com.itlize.order.dto.OrderDTO;
import com.itlize.order.enums.ResultEnum;
import com.itlize.order.exception.OrderException;
import com.itlize.order.form.OrderForm;
import com.itlize.order.repository.OrderDetailRepository;
import com.itlize.order.repository.OrderMasterRepository;
import com.itlize.order.service.OrderService;
import com.itlize.order.utils.ResultVOUtil;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;



/**
 *   * 1. Parameter inspection
     * 2. Query product information (call product service)
     * 3. Calculate the total price
     * 4. Deduct inventory (call goods service)
     * 5. Order storage
     * */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("[Create order] Parameter is incorrect, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[Create order] Shopping cart information is empty");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }



}
