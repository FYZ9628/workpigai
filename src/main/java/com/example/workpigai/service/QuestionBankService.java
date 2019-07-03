package com.example.workpigai.service;

import com.example.workpigai.dao.QuestionBankDao;
import com.example.workpigai.model.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBankService {

    @Autowired
    QuestionBankDao questionBankDao;

    public List<QuestionBank> questionBankList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return questionBankDao.findAll(sort);
    }


    //添加或更新题库信息
    public QuestionBank addOrUpdateQuestionBank(QuestionBank questionBank) {
        return questionBankDao.save(questionBank);
    }

    //根据题库号或题库名称查询
    public List<QuestionBank> findAllByQuestionIdLikeOrTitleLike(String keywords) {
        return questionBankDao.findAllByQuestionIdLikeOrTitleLike('%'
                + keywords + '%', '%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        questionBankDao.deleteById(id);
    }

    //    通过  id 查询
    public QuestionBank findById(int id){
        return questionBankDao.findById(id);
    }

    public boolean isExist(int id) {
        QuestionBank questionBank = findById(id);
        return null!=questionBank;
    }
}
