package com.example.workpigai.dao;

import com.example.workpigai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *  数据持久层  提供简单的操作接口
 *
 *  dao 层提供对数据的增删查改操作接口，具体的操作在 service 层实现
 */
public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}

