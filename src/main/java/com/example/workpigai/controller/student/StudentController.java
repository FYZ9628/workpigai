package com.example.workpigai.controller.student;

import com.example.workpigai.model.Work;
import com.example.workpigai.result.Search;
import com.example.workpigai.result.SubmitAnswerPost;
import com.example.workpigai.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class StudentController {

    @Autowired
    WorkService workService;

    @PostMapping("/api/getStudentPersonalWork")
    public List<Work> findAllByStudent_User_Account(@RequestBody Search s) throws Exception {

        return workService.findAllByStudent_User_Account(s.getKeywords());
    }

    @PostMapping("/api/submitAnswer")
    public Work submitAnswer(@RequestBody SubmitAnswerPost submitAnswerPost) throws Exception {
        //因为前端只是传了一个 id (序号) 过来
        //所以要再通过 id 查询 Class 的其他信息
        Work work = workService.findById(submitAnswerPost.getWorkId());
        if (work != null){
            work.setSubmitContent(submitAnswerPost.getSubmitContent());
            work.setState("已提交");
            workService.addOrUpdateWork(work);
            return work;
        } else {
            return null;
        }
    }



}
