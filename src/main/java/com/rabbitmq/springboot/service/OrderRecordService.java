package com.rabbitmq.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.springboot.domain.OrderRecord;
import com.rabbitmq.springboot.mapper.OrderRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Rison_Lee on 2020/1/17 9:19.
 * @version 1.0
 */
@Service
public class OrderRecordService {
    @Resource
    private OrderRecordMapper orderRecordMapper;

    /**
     * 删除 by id
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
        return orderRecordMapper.deleteById(id);
    }

    /**
     * 新增
     * @param record
     * @return
     */
    public int insert(OrderRecord record){
        return orderRecordMapper.insert(record);

    }

    /**
     * 查询 by id
     * @param id
     * @return
     */
    public OrderRecord selectByPrimaryKey(Integer id){
        return orderRecordMapper.selectById(id);
    }

    /**
     * 更新 by id
     * @param record
     * @return
     */
    public int updateByPrimaryKey(OrderRecord record){
        return orderRecordMapper.updateById(record);
    }

    public List<OrderRecord> selectAll(){
        return orderRecordMapper.selectList(new LambdaQueryWrapper<OrderRecord>());
    }
}
