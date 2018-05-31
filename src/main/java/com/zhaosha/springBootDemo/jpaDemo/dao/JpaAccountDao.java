package com.zhaosha.springBootDemo.jpaDemo.dao;

import com.zhaosha.springBootDemo.jpaDemo.bean.JpaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rainsherry on 2018/5/31.
 */
public interface JpaAccountDao extends JpaRepository<JpaAccount, Integer> {
}
