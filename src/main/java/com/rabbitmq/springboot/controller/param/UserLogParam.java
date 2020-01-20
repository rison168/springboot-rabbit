package com.rabbitmq.springboot.controller.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Rison_Lee on 2020/1/20 9:36.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogParam implements Serializable {
    private String userName;

    private String module;

    private String operation;

    private String data;

    private Date createTime;
}

