package com.example.workpigai.service;

import com.example.workpigai.dao.UserDAO;
import com.example.workpigai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 业务逻辑层  具体的操作实现
 *
 *  dao 层提供对数据的增删查改操作接口，具体的操作在 service 层实现
 *
 *  service 层调用 dao 层接口的实现具体的操作
 */

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.save(user);
    }
}

