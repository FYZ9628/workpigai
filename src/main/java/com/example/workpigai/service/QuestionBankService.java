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
}
