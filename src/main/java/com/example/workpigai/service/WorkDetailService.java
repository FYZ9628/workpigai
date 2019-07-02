package com.example.workpigai.service;

import com.example.workpigai.dao.WorkDetailDao;
import com.example.workpigai.model.WorkDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkDetailService {

    @Autowired
    WorkDetailDao workDetailDao;

    public List<WorkDetail> workDetailList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return workDetailDao.findAll(sort);
    }
}
