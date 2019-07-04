package com.example.workpigai.controller;

import com.example.workpigai.model.QuestionBank;
import com.example.workpigai.model.Teacher;
import com.example.workpigai.model.Work;
import com.example.workpigai.model.WorkDetail;
import com.example.workpigai.result.CheckWorkPost;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.QuestionBankService;
import com.example.workpigai.service.TeacherService;
import com.example.workpigai.service.WorkDetailService;
import com.example.workpigai.service.WorkService;
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
public class TeacherController {

    @Autowired
    WorkService workService;
    @Autowired
    WorkDetailService workDetailService;
    @Autowired
    QuestionBankService questionBankService;
    @Autowired
    TeacherService teacherService;


    @PostMapping("/api/getTeacher")
    public Teacher getTeacher(@RequestBody Teacher teacher) throws Exception {
        //因为前端只是传了一个 id (序号) 过来
        //所以要再通过 id 查询 Class 的其他信息
        Teacher teacher1 = teacherService.findByUser_Account(teacher.getUser().getAccount());
        if (teacher1 != null){
            return teacher1;
        } else {
            return null;
        }
    }

    @PostMapping("/api/checkWork")
    public Work checkWork(@RequestBody CheckWorkPost checkWorkPost) throws Exception {
        //因为前端只是传了一个 id (序号) 过来
        //所以要再通过 id 查询 Class 的其他信息
        Work work = workService.findById(checkWorkPost.getWorkId());
        if (work != null){
            work.setScore(checkWorkPost.getScore());
            workService.addOrUpdateWork(work);
            return work;
        } else {
            return null;
        }
    }



//    @GetMapping("/api/workInfo")
//    public List<Work> workList() throws Exception {
//        return workService.workList();
//    }
//
//    @GetMapping("/api/workDetailInfo")
//    public List<WorkDetail> workDetailList() throws Exception {
//        return workDetailService.workDetailList();
//    }
//
//
//    @GetMapping("/api/questionBankInfo")
//    public List<QuestionBank> questionBankList() throws Exception {
//        return questionBankService.questionBankList();
//    }









}
