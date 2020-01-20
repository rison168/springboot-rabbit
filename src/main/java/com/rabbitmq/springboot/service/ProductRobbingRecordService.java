package com.rabbitmq.springboot.service;

import com.rabbitmq.springboot.domain.ProductRobbingRecord;
import com.rabbitmq.springboot.mapper.ProductRobbingRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/1/17 9:56.
 * @version 1.0
 */
@Service
public class ProductRobbingRecordService {
    @Resource
    private ProductRobbingRecordMapper productRobbingRecordMapper;

    /**
     * 删除 by id
     *
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return productRobbingRecordMapper.deleteById(id);
    }

    /**
     * 新增
     *
     * @param record
     * @return
     */
    public int insert(ProductRobbingRecord record) {
        return productRobbingRecordMapper.insert(record);
    }

    /**
     * 查询 by id
     *
     * @param id
     * @return
     */
    public ProductRobbingRecord selectByPrimaryKey(Integer id) {
        return productRobbingRecordMapper.selectById(id);
    }

    /**
     * 更新
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKey(ProductRobbingRecord record) {
        return productRobbingRecordMapper.updateById(record);
    }


}
