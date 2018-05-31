package com.zhaosha.springBootDemo.mybatisDemo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Mapper
public interface AccountTraMapper {

    int update(@Param("money") double money, @Param("id") int id);
}
