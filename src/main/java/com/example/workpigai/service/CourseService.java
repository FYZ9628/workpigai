package com.example.workpigai.service;

import com.example.workpigai.dao.CourseDao;
import com.example.workpigai.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public List<Course> courseList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return courseDao.findAll(sort);
    }

    //    通过  id 查询
    public Course findById(int id){
        return courseDao.findById(id);
    }


}
