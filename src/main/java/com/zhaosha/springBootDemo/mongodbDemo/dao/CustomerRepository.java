package com.zhaosha.springBootDemo.mongodbDemo.dao;

import com.zhaosha.springBootDemo.mongodbDemo.bean.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 继承MongoRepository，这个接口有了基本的curd功能
 * 如果想自定义一些查询，只需要定义一个方法即可，但是字段要严格按照mongodb中的字段对应
 * Created by rainsherry on 2018/5/31.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    /**
     * 函数名字一定要和参数保持一致，例如函数名为findByFirstname，则参数firstName找不到
     *
     * @param firstName
     * @return
     */
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
