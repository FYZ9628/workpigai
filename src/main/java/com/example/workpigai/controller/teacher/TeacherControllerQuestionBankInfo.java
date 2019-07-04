package com.example.workpigai.controller.teacher;


import com.example.workpigai.model.QuestionBank;
import com.example.workpigai.model.Search;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.QuestionBankService;
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
public class TeacherControllerQuestionBankInfo {

    @Autowired
    QuestionBankService questionBankService;


    @GetMapping("/api/questionBankInfo")
    public List<QuestionBank> questionBankList() throws Exception {
        return questionBankService.questionBankList();
    }



    @PostMapping("/api/searchQuestionBank")
    public List<QuestionBank> findAllByQuestionIdLikeOrTitleLike(@RequestBody Search s) throws Exception {

        return questionBankService.findAllByQuestionIdLikeOrTitleLike(s.getKeywords());
    }


    @PostMapping("/api/addQuestionBank")
    public QuestionBank addQuestionBank(@RequestBody QuestionBank questionBank) throws Exception {

        boolean bl = questionBankService.isExist(questionBank.getId());
        if (bl == true){
            return null;
        }else {
            questionBank = questionBankService.addOrUpdateQuestionBank(questionBank);
            return questionBank;
        }
    }

    @PostMapping("/api/updateQuestionBank")
    public QuestionBank updateQuestionBank(@RequestBody QuestionBank questionBank) throws Exception {

        boolean bl = questionBankService.isExist(questionBank.getId());
        if (bl == true){
            questionBank = questionBankService.addOrUpdateQuestionBank(questionBank);
            return questionBank;
        }else {
            return null;
        }
    }


//    @PostMapping("/api/deleteQuestionBank")
//    public Result deleteClass(@RequestBody int id) throws Exception {
//        //因为前端只是传了一个 id (序号) 过来
//        //所以要再通过 id 查询 Class 的其他信息
//        QuestionBank questionBank = questionBankService.findById(id);
//        if (questionBank != null){
//            questionBankService.deleteById(id);
//            //   删除成功返回码 100
//            return new Result(100);
//        } else {
//            //   删除失败返回码 400
//            return new Result(400);
//        }
//    }


    @PostMapping("/api/deleteQuestionBank")
    public Result deleteClass(@RequestBody QuestionBank questionBank) throws Exception {
        //因为前端只是传了一个 id (序号) 过来，所以 mClassId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 Class 的其他信息

        QuestionBank questionBank1 = questionBankService.findById(questionBank.getId());
        if (questionBank1 != null){
            questionBankService.deleteById(questionBank.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }


}
