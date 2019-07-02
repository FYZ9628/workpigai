package com.example.workpigai.service;

import com.example.workpigai.dao.UserDao;
import com.example.workpigai.model.Teacher;
import com.example.workpigai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    UserDao userDao;

    public boolean isExist(String account) {
        User user = getByAccount(account);
        return null!=user;
    }

    public User getByAccount(String account) {
        return userDao.findByAccount(account);
    }

    public User get(String account, String password){
        return userDao.getByAccountAndPassword(account, password);
    }

    public void add(User user) {
        userDao.save(user);
    }

    //    通过 id 删除
    public void deleteById(int id) {
        userDao.deleteById(id);
    }



    //----------------------------------- 暂时没有用到 ------------------------------------------------------
    public List<User> searchByAccount(String account) {
        return userDao.findAllByAccountLike(account);
    }
    //----------------------------------- 暂时没有用到 ------------------------------------------------------
}

