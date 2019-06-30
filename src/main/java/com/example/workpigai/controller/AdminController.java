package com.example.workpigai.controller;

import com.example.workpigai.model.*;
import com.example.workpigai.model.Class;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.ClassService;
import com.example.workpigai.service.StudentService;
import com.example.workpigai.service.TeacherService;
import com.example.workpigai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class AdminController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @GetMapping("/api/teacherInfo")
    public List<Teacher> teacherList() throws Exception {
        return teacherService.teacherList();
    }

    @GetMapping("/api/classInfo")
    public List<Class> classList() throws Exception {
        return classService.classList();
    }


    @GetMapping("/api/studentInfo")
    public List<Student> studentList() throws Exception {
        return studentService.studentList();
    }


    @PostMapping("/api/searchTeacher")
    public List<Teacher> findAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return teacherService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
    }



    @PostMapping("/api/addTeacher")
    public Teacher addOrUpdate(@RequestBody Teacher teacher) throws Exception {

        userService.add(teacher.getUser());
        teacher = teacherService.addOrUpTeacher(teacher);

        return teacher;
    }










    //----------------------------------- 暂时没有用到 ------------------------------------------------------
    @PostMapping("/api/addUser")
    public User addUser(@RequestBody User user) throws Exception {
        userService.add(user);
        return user;
    }

    @PostMapping("/api/searchAllTeacherByUser")
    public List<Teacher> searchAllTeacherByUser( User user) throws Exception {

        return teacherService.searchAllTeacherByUser(user);
    }

    @PostMapping("/api/searchTeacherByUser")
    public Teacher searchTeacherByUser( User user) throws Exception {

        return teacherService.searchTeacherByUser(user);
    }

    @CrossOrigin
    @PostMapping("/api/searchAllByUserAccount")
    @ResponseBody
    public List<Teacher> findTeachersByUser_Account(@RequestBody String account) throws Exception {

        return teacherService.findTeachersByUser_Account(account);
    }

    @PostMapping(value = "api/searchTest")
    public Result searchTest( String account) {

        return new Result(800);

    }
    //----------------------------------- 暂时没有用到 ------------------------------------------------------

}
