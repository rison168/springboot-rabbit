package com.rabbitmq.springboot.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.springboot.domain.UserLog;
import com.rabbitmq.springboot.service.UserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Rison_Lee on 2020/1/19 15:19.
 * @version 1.0
 */
@Component
public class UserLogListener {
    private static final Logger log = LoggerFactory.getLogger(UserLogListener.class);

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private UserLogService userLogService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${log.user.queue.name}", durable = "true"),
            exchange = @Exchange(
                    value = "${log.user.exchange.name}",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void loginLog(@Payload UserLog userLog){
            userLogService.insert(userLog);
            log.info("登录日志新增成功:->" +  userLog);
    }


}
