package com.rabbitmq.springboot.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Rison_Lee on 2020/1/16 10:23.
 * @version 1.0
 */
@Data
@TableName("user")
public class User implements Serializable {
    @TableId
    private Integer id;

    private String userName;

    private String name;

}
