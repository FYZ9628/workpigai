package com.example.workpigai.dao;

import com.example.workpigai.model.ChoseCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 *  数据持久层  提供简单的操作接口
 *
 *  dao 层提供对数据的增删查改操作接口，具体的操作在 service 层实现
 */
public interface ChoseCourseDao extends JpaRepository<ChoseCourse,Integer> {

    List<ChoseCourse> findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike(String courseName, String teacherName, String className);

    ChoseCourse findById(int id);


}
