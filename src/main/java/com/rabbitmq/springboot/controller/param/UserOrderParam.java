package com.rabbitmq.springboot.controller.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rison_Lee on 2020/2/20 9:42.
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOrderParam {
    private String orderNo;
    private String userId;
}
