package com.rabbitmq.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Rison_Lee on 2020/1/16 10:23.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_order")
public class UserOrder implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String orderNo;

    private Integer userId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}