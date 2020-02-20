package com.rabbitmq.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.springboot.common.BaseResponse;
import com.rabbitmq.springboot.common.StatusCode;
import com.rabbitmq.springboot.controller.param.UserOrderParam;
import com.rabbitmq.springboot.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/2/20 9:20.
 * @version 1.0
 */
@RestController
@RequestMapping("/user/order")
public class UserOrderController {
    private static final Logger log = LoggerFactory.getLogger(UserOrderController.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private Environment environment;

    @Resource
    private UserOrderService userOrderService;

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 用户下单
     * @param param
     * @return
     */
    @PostMapping("/push")
    public BaseResponse pushUserOrder(@RequestBody UserOrderParam param) {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        log.debug("接收到数据： {}", param);

        try {
            //TODO: 用户下单记录（入库）
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange(environment.getProperty("user.order.exchange.name"));
            rabbitTemplate.setRoutingKey(environment.getProperty("user.order.routing.key.name"));
            Message msg = MessageBuilder.withBody(objectMapper.writeValueAsBytes(param)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
            return response;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new BaseResponse(StatusCode.Fail);
    }
}
