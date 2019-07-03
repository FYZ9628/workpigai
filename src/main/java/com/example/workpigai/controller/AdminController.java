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

    //--------------------------- get 请求 start ------------------------------------------

//    @GetMapping("/api/teacherInfo")
//    public List<Teacher> teacherList() throws Exception {
//        return teacherService.teacherList();
//    }

//    @GetMapping("/api/classInfo")
//    public List<Class> classList() throws Exception {
//        return classService.classList();
//    }


//    @GetMapping("/api/studentInfo")
//    public List<Student> studentList() throws Exception {
//        return studentService.studentList();
//    }


//    @GetMapping("/api/choseCourseInfo")
//    public List<ChoseCourse> choseCourseList() throws Exception {
//        return choseCourseService.choseCourseList();
//    }

    //--------------------------- get 请求 end ------------------------------------------



    //--------------------------- 教师 post 请求 start ------------------------------------------
//    @PostMapping("/api/searchTeacher")
//    public List<Teacher> teacherFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {
//
//        return teacherService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
//    }
//
//
//    @PostMapping("/api/addTeacher")
//    public Teacher addTeacher(@RequestBody Teacher teacher) throws Exception {
//
//        boolean bl = userService.isExist(teacher.getUser().getAccount());
//        if (bl == true){
//            return null;
//        }else {
//            userService.add(teacher.getUser());
//            teacher = teacherService.addOrUpTeacher(teacher);
//
//            return teacher;
//        }
//
//    }
//
//    @PostMapping("/api/updateTeacher")
//    public Teacher updateTeacher(@RequestBody Teacher teacher) throws Exception {
//
//        boolean bl = userService.isExist(teacher.getUser().getAccount());
//        if (bl == true){
//            userService.add(teacher.getUser());
//            teacher = teacherService.addOrUpTeacher(teacher);
//            return teacher;
//        }else {
//            return null;
//        }
//
//    }
//
//
//    @PostMapping("/api/deleteTeacher")
//    public Result deleteTeacher(@RequestBody Teacher teacherId) throws Exception {
//        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
//        //所以要再通过 id 查询 teacher 的其他信息
//        Teacher teacher = teacherService.findById(teacherId.getId());
//        if (teacher != null){
//            teacherService.deleteById(teacherId.getId());
//            userService.deleteById(teacher.getUser().getId());
//            //   删除成功返回码 100
//            return new Result(100);
//        } else {
//            //   删除失败返回码 400
//            return new Result(400);
//        }
//    }

    //--------------------------- 教师 post 请求 end ------------------------------------------



    //--------------------------- 学生 post 请求 start ------------------------------------------

//    @PostMapping("/api/searchStudent")
//    public List<Student> studentFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {
//
//        return studentService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
//    }
//
//
//    @PostMapping("/api/addStudent")
//    public Student addOrUpdateStudent(@RequestBody Student student) throws Exception {
//
//        boolean bl = userService.isExist(student.getUser().getAccount());
//        if (bl == true){
//            return null;
//        }else {
//            userService.add(student.getUser());
//            student = studentService.addOrUpStudent(student);
//
//            return student;
//        }
//    }
//
//    @PostMapping("/api/updateStudent")
//    public Student updateStudent(@RequestBody Student student) throws Exception {
//
//        boolean bl = userService.isExist(student.getUser().getAccount());
//        if (bl == true){
//            userService.add(student.getUser());
//            student = studentService.addOrUpStudent(student);
//            return student;
//        }else {
//            return null;
//        }
//    }
//
//
//    @PostMapping("/api/deleteStudent")
//    public Result deleteStudent(@RequestBody Student studentId) throws Exception {
//        //因为前端只是传了一个 id 过来，所以 teacherId 里面只有一个 id 没有其他信息
//        //所以要再通过 id 查询 teacher 的其他信息
//        Student student = studentService.findById(studentId.getId());
//        if (student != null){
//            studentService.deleteById(studentId.getId());
//            userService.deleteById(student.getUser().getId());
//            //   删除成功返回码 100
//            return new Result(100);
//        } else {
//            //   删除失败返回码 400
//            return new Result(400);
//        }
//    }

    //--------------------------- 学生 post 请求 end ------------------------------------------


    //--------------------------- 班级 post 请求 start ------------------------------------------

//    @PostMapping("/api/searchClass")
//    public List<Class> classFindAllByClassIdLikeOrClassNameLike(@RequestBody Search s) throws Exception {
//
//        return classService.findAllByClassIdLikeOrClassNameLike(s.getKeywords());
//    }
//
//    @PostMapping("/api/addClass")
//    public Class addClass(@RequestBody Class mClass) throws Exception {
//
//        boolean bl = classService.isExist(mClass.getId());
//        if (bl == true){
//            return null;
//        }else {
//            mClass = classService.addOrUpdateClass(mClass);
//            return mClass;
//        }
//    }
//    @PostMapping("/api/updateClass")
//    public Class updateClass(@RequestBody Class mClass) throws Exception {
//
//        boolean bl = classService.isExist(mClass.getId());
//        if (bl == true){
//            mClass = classService.addOrUpdateClass(mClass);
//            return mClass;
//        }else {
//            return null;
//        }
//    }
//
//    @PostMapping("/api/deleteClass")
//    public Result deleteClass(@RequestBody Class mClassId) throws Exception {
//        //因为前端只是传了一个 id (序号) 过来，所以 mClassId 里面只有一个 id 没有其他信息
//        //所以要再通过 id 查询 Class 的其他信息
//        Class mClass = classService.findById(mClassId.getId());
//        if (mClass != null){
//            classService.deleteById(mClassId.getId());
//            //   删除成功返回码 100
//            return new Result(100);
//        } else {
//            //   删除失败返回码 400
//            return new Result(400);
//        }
//    }

    //--------------------------- 班级 post 请求 end ------------------------------------------


    //--------------------------- 选课 post 请求 start ------------------------------------------

//    @PostMapping("/api/searchChoseCourse")
//    public List<ChoseCourse> findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike(@RequestBody Search s)
//            throws Exception {
//
//        return choseCourseService.findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike(s.getKeywords());
//    }
//
//    @PostMapping("/api/addChoseCourse")
//    public ChoseCourse addChoseCourse(@RequestBody ChoseCourse choseCourse) throws Exception {
//
//        boolean bl = choseCourseService.isExist(choseCourse.getId());
//        if (bl == true){
//            return null;
//        }else {
//            choseCourse = choseCourseService.addOrUpdateChoseCourse(choseCourse);
//            return choseCourse;
//        }
//    }
//
//    @PostMapping("/api/updateChoseCourse")
//    public ChoseCourse updateChoseCourse(@RequestBody ChoseCourse choseCourse) throws Exception {
//
//        boolean bl = choseCourseService.isExist(choseCourse.getId());
//        if (bl == true){
//            choseCourse = choseCourseService.addOrUpdateChoseCourse(choseCourse);
//            return choseCourse;
//        }else {
//            return null;
//        }
//    }
//
//
//    @PostMapping("/api/deleteChoseCourse")
//    public Result deleteChoseCourse(@RequestBody ChoseCourse choseCourseId) throws Exception {
//        //因为前端只是传了一个 id (序号) 过来，所以 choseCourseId 里面只有一个 id 没有其他信息
//        //所以要再通过 id 查询 ChoseCourse 的其他信息
//        ChoseCourse choseCourse = choseCourseService.findById(choseCourseId.getId());
//        if (choseCourse != null){
//            choseCourseService.deleteById(choseCourseId.getId());
//            //   删除成功返回码 100
//            return new Result(100);
//        } else {
//            //   删除失败返回码 400
//            return new Result(400);
//        }
//    }

    //--------------------------- 选课 post 请求 end ------------------------------------------


    //--------------------------- 题库 post 请求 start ------------------------------------------


    //--------------------------- 题库 post 请求 end ------------------------------------------







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
