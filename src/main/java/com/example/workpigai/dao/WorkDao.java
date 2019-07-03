package com.example.workpigai.dao;

import com.example.workpigai.model.User;
import com.example.workpigai.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 *
 *  数据持久层  提供简单的操作接口
 *
 *  dao 层提供对数据的增删查改操作接口，具体的操作在 service 层实现
 */
public interface WorkDao extends JpaRepository<Work,Integer> {

    List<Work> findAllByTeacher_NameLikeOrWorkDetail_WorkTitleLike(String teacherName, String workTitle);

    Work findById(int id);

}
