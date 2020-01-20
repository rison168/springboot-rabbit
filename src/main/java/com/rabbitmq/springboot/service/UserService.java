package com.rabbitmq.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.springboot.domain.User;
import com.rabbitmq.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Rison_Lee on 2020/1/16 12:01.
 * @version 1.0
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 删除用户信息 by id
     *
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteById(id);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 查询 by id
     *
     * @param id
     * @return
     */
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    public int updateByPrimaryKey(User user) {
        return userMapper.updateById(user);
    }

    /**
     * 查询 by userName and password
     *
     * @param userName
     * @param password
     * @return
     */
    public User selectByUserNamePassword(String userName, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getUserName, userName).eq(User::getPassword, password);
        return userMapper.selectOne(wrapper);
    }


}
