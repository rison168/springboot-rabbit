package com.rabbitmq.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.springboot.common.BaseResponse;
import com.rabbitmq.springboot.common.StatusCode;
import com.rabbitmq.springboot.controller.param.UserLogParam;
import com.rabbitmq.springboot.domain.User;
import com.rabbitmq.springboot.domain.UserLog;
import com.rabbitmq.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author Rison_Lee on 2020/1/17 14:04.
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private Environment environment;

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public BaseResponse<User> login(@NotBlank(message = "用户名不能为空") String userName, @NotBlank(message = "密码不能为空") String password) {
        User user = userService.selectByUserNamePassword(userName, password);
        //登录成功，异步写日志
        if (user != null) {
            try {
                UserLog userLog = new UserLog();
                UserLogParam userLogParam = new UserLogParam(userName, "Login", "login", objectMapper.writeValueAsString(user), new Date());
                BeanUtils.copyProperties(userLogParam, userLog);
                rabbitTemplate.convertAndSend(environment.getProperty("log.user.exchange.name"),"", userLog);
                log.info("登录日志发送成功: ->" + userLog);
                return new BaseResponse<User>(StatusCode.Success, user);
            } catch (JsonProcessingException e) {
                log.error("error: ->" + e.getMessage());
                e.printStackTrace();
            }
        }
        return new BaseResponse<User>(StatusCode.Fail);
    }



}
