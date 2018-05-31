package com.zhaosha.springBootDemo.mybatisDemo;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Mapper
public interface AccountMapper {

    @Insert("insert into account(name,money) values(#{name},#{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id,name,money from account where id = #{id}")
    Account findAccount(int id);

    @Select("select id,name,money from account")
    List<Account> findAccountList();

}
