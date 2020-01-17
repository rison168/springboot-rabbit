package com.rabbitmq.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.springboot.domain.Product;
import com.rabbitmq.springboot.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/1/17 9:39.
 * @version 1.0
 */
@Service
public class ProductService {
    @Resource
    private ProductMapper productMapper;

    /**
     * 删除 by id
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
        return productMapper.deleteById(id);
    }

    /**
     * 新增
     * @param record
     * @return
     */
    public int insert(Product record){
        return productMapper.insert(record);
    }

    /**
     * 查询 by id
     * @param id
     * @return
     */
    public Product selectByPrimaryKey(Integer id){
        return productMapper.selectById(id);
    }

    /**
     * 更新
     * @param record
     * @return
     */
    public int updateByPrimaryKey(Product record){
        return productMapper.updateById(record);
    }

    /**
     * 查询 by productNo
     * @param productNo
     * @return
     */
    public Product selectByProductNo(String productNo){
        return productMapper.selectOne(new LambdaQueryWrapper<Product>().eq(Product::getProductNo, productNo));
    }

    /**
     * 更新库存量
     * @param record
     * @return
     */
    public int updateTotal(Product record){
        Integer total = this.selectByProductNo(record.getProductNo()).getTotal();
        if (total > 0) {
            record.setTotal(total - 1);
            return this.updateByPrimaryKey(record);

        }
        return 0;
    }
}
