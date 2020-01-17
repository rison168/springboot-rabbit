package com.rabbitmq.springboot.service;

import com.rabbitmq.springboot.domain.UserLog;
import com.rabbitmq.springboot.mapper.UserLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/1/17 9:58.
 * @version 1.0
 */
@Service
public class UserLogService {
    @Resource
    private UserLogMapper userLogMapper;

    /**
     * 删除 by id
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
        return  userLogMapper.deleteById(id);
    }

    /**
     * 新增
     * @param record
     * @return
     */
    public int insert(UserLog record){
        return userLogMapper.insert(record);

    }

    /**
     * 查询 by id
     * @param id
     * @return
     */
    public UserLog selectByPrimaryKey(Integer id){
        return userLogMapper.selectById(id);
    }

    /**
     * 更新 by id
     * @param record
     * @return
     */
    public int updateByPrimaryKey(UserLog record){
        return userLogMapper.updateById(record);
    }
}
