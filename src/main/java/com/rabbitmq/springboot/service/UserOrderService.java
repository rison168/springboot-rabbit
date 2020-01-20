package com.rabbitmq.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.springboot.domain.UserOrder;
import com.rabbitmq.springboot.mapper.UserOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/1/17 9:58.
 * @version 1.0
 */
@Service
public class UserOrderService {
    @Resource
    private UserOrderMapper userOrderMapper;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return userOrderMapper.deleteById(id);
    }

    /**
     * 新增
     *
     * @param record
     * @return
     */
    public int insert(UserOrder record) {
        return userOrderMapper.insert(record);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public UserOrder selectByPrimaryKey(Integer id) {
        return userOrderMapper.selectById(id);
    }

    /**
     * 更新
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKey(UserOrder record) {
        return userOrderMapper.updateById(record);
    }

    /**
     * 查询 by id and status
     *
     * @param id
     * @param status
     * @return
     */
    public UserOrder selectByPkAndStatus(Integer id, Integer status) {
        return userOrderMapper.selectOne(new LambdaQueryWrapper<UserOrder>().eq(UserOrder::getId, id).eq(UserOrder::getStatus, status));
    }
}
