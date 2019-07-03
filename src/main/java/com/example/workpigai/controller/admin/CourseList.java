package com.example.workpigai.controller.admin;

import com.example.workpigai.model.Course;
import com.example.workpigai.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class CourseList {
    @Autowired
    CourseService courseService;

    @GetMapping("/api/courseList")
    public List<Course> courseList() throws Exception {
        return courseService.courseList();
    }

}
