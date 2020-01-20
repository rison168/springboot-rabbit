package com.rabbitmq.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Rison_Lee on 2020/1/16 10:23.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String productNo;

    private Integer total;

    private Date createTime;

    private Date updateTime;

}