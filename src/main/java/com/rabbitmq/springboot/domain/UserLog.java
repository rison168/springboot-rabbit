package com.rabbitmq.springboot.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
/**
 * @author Rison_Lee on 2020/1/16 10:23.
 * @version 1.0
 */
@Data
@TableName("user_log")
public class UserLog {
    @TableId
    private Integer id;

    private String userName;

    private String module;

    private String operation;

    private String data;

    private Date createTime;

    private Date updateTime;

}