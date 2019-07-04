package com.example.workpigai.controller.admin;

import com.example.workpigai.model.Class;
import com.example.workpigai.model.Search;
import com.example.workpigai.model.Student;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.ClassService;
import com.example.workpigai.service.StudentService;
import com.example.workpigai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class AdminControllerStudentInfo {

    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;
    @Autowired
    ClassService classService;


    @GetMapping("/api/studentInfo")
    public List<Student> studentList() throws Exception {
        return studentService.studentList();
    }

    @PostMapping("/api/searchStudent")
    public List<Student> studentFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return studentService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
    }


    @PostMapping("/api/addStudent")
    public Student addOrUpdateStudent(@RequestBody Student student) throws Exception {

        boolean bl = userService.isExist(student.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(student.getUser());
            student = studentService.addOrUpStudent(student);

            return student;
        }
    }

    @PostMapping("/api/updateStudent")
    public Student updateStudent(@RequestBody Student student) throws Exception {



        boolean bl = userService.isExist(student.getUser().getAccount());
        if (bl == true){
            Class mClass = classService.findById(student.getmClass().getId());
            student.setmClass(mClass);
            userService.add(student.getUser());
            student = studentService.addOrUpStudent(student);
            return student;
        }else {
            return null;
        }
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

}
