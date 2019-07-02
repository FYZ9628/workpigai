package com.example.workpigai.controller;

import com.example.workpigai.model.*;
import com.example.workpigai.model.Class;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.*;
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
    @Autowired
    ChoseCourseService choseCourseService;

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


    @GetMapping("/api/choseCourseInfo")
    public List<ChoseCourse> choseCourseList() throws Exception {
        return choseCourseService.choseCourseList();
    }



    @PostMapping("/api/searchTeacher")
    public List<Teacher> teacherFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return teacherService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
    }


    @PostMapping("/api/addTeacher")
    public Teacher addOrUpdateTeacher(@RequestBody Teacher teacher) throws Exception {

        userService.add(teacher.getUser());
        teacher = teacherService.addOrUpTeacher(teacher);

        return teacher;
    }


    @PostMapping("/api/deleteTeacher")
    public Result deleteTeacher(@RequestBody Teacher teacherId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Teacher teacher = teacherService.findById(teacherId.getId());
        if (teacher != null){
            teacherService.deleteById(teacherId.getId());
            userService.deleteById(teacher.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }




    @PostMapping("/api/searchStudent")
    public List<Student> studentFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return studentService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
    }


    @PostMapping("/api/addStudent")
    public Student addOrUpdateStudent(@RequestBody Student student) throws Exception {

        userService.add(student.getUser());
        student = studentService.addOrUpStudent(student);

        return student;
    }


    @PostMapping("/api/deleteStudent")
    public Result deleteStudent(@RequestBody Student studentId) throws Exception {
        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 teacher 的其他信息
        Student student = studentService.findById(studentId.getId());
        if (student != null){
            studentService.deleteById(studentId.getId());
            userService.deleteById(student.getUser().getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
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
