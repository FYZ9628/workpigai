package com.example.workpigai.service;

import com.example.workpigai.dao.ClassDao;
import com.example.workpigai.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    ClassDao classDao;

    public List<Class> classList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return classDao.findAll(sort);
    }
}
