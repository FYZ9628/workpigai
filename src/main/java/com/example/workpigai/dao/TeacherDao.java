package com.example.workpigai.dao;

import com.example.workpigai.model.Teacher;
import com.example.workpigai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {

    List<Teacher> findAllByNameLikeOrUser_AccountLike(String name, String account);


    //----------------------------------- 暂时没有用到 ------------------------------------------------------
    List<Teacher> findAllByUser(User user);
    List<Teacher> findTeachersByUser_Account(String account);
    Teacher findByUser(User user);
    List<Teacher> findAllByNameLike(String keyword1);
    //----------------------------------- 暂时没有用到 ------------------------------------------------------

}
