package com.example.workpigai.controller;

import com.example.workpigai.model.QuestionBank;
import com.example.workpigai.model.Work;
import com.example.workpigai.model.WorkDetail;
import com.example.workpigai.service.QuestionBankService;
import com.example.workpigai.service.WorkDetailService;
import com.example.workpigai.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/api/workInfo")
    public List<Work> workList() throws Exception {
        return workService.workList();
    }

    @GetMapping("/api/workDetailInfo")
    public List<WorkDetail> workDetailList() throws Exception {
        return workDetailService.workDetailList();
    }


    @GetMapping("/api/questionBankInfo")
    public List<QuestionBank> questionBankList() throws Exception {
        return questionBankService.questionBankList();
    }



}
