package com.example.workpigai.dao;

import com.example.workpigai.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {


}
