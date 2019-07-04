package com.example.workpigai.controller.admin;

import com.example.workpigai.result.Search;
import com.example.workpigai.model.Teacher;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.TeacherService;
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
public class AdminControllerTeacherInfo {

    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;

    @GetMapping("/api/teacherInfo")
    public List<Teacher> teacherList() throws Exception {
        return teacherService.teacherList();
    }


    @PostMapping("/api/searchTeacher")
    public List<Teacher> teacherFindAllByNameLikeOrUser_AccountLike(@RequestBody Search s) throws Exception {

        return teacherService.findAllByNameLikeOrUser_AccountLike(s.getKeywords());
    }


    @PostMapping("/api/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) throws Exception {

        boolean bl = userService.isExist(teacher.getUser().getAccount());
        if (bl == true){
            return null;
        }else {
            userService.add(teacher.getUser());
            teacher = teacherService.addOrUpTeacher(teacher);

            return teacher;
        }

    }

    @PostMapping("/api/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) throws Exception {

        boolean bl = userService.isExist(teacher.getUser().getAccount());
        if (bl == true){
            userService.add(teacher.getUser());
            teacher = teacherService.addOrUpTeacher(teacher);
            return teacher;
        }else {
            return null;
        }

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

}
