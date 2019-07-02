package com.example.workpigai.service;

import com.example.workpigai.dao.WorkDao;
import com.example.workpigai.model.Teacher;
import com.example.workpigai.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    @Autowired
    WorkDao workDao;

    public List<Work> workList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return workDao.findAll(sort);
    }
}
