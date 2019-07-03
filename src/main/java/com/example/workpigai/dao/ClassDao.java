package com.example.workpigai.dao;

import com.example.workpigai.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassDao extends JpaRepository<Class,Integer> {

    List<Class> findAllByClassIdLikeOrClassNameLike(String classId, String className);

    Class findById(int id);
}
