package com.rabbitmq.springboot.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Rison_Lee on 2020/1/16 10:23.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto implements Serializable {

    private String orderNo;

    private Integer userId;
}
