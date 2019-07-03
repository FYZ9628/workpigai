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


    //添加或更新教师已经发布的作业信息
    public WorkDetail addOrUpdateWorkDetail(WorkDetail workDetail) {
        return workDetailDao.save(workDetail);
    }

    //根据发布的作业标题查询
    public List<WorkDetail> findAllByWorkTitleLike(String keywords) {
        return workDetailDao.findAllByWorkTitleLike('%'
                + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        workDetailDao.deleteById(id);
    }

    //    通过  id 查询
    public WorkDetail findById(int id){
        return workDetailDao.findById(id);
    }

    public boolean isExist(int id) {
        WorkDetail workDetail = findById(id);
        return null!=workDetail;
    }

}
