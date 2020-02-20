package com.rabbitmq.springboot.rabbitmq;

import com.rabbitmq.springboot.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/2/20 10:10.
 * @version 1.0
 */
@Component
public class UserOrderListener {
    private static final Logger log = LoggerFactory.getLogger(UserOrderListener.class);

    @Resource
    private UserOrderService userOrderService;


}
