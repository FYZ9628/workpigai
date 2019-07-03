package com.example.workpigai.dao;

import com.example.workpigai.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Integer> {

    Course findById(int id);

}
