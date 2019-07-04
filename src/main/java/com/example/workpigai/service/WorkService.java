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


    //添加或更新教师已经发布的作业信息
    public Work addOrUpdateWork(Work work) {
        return workDao.save(work);
    }

    //根据教师名称或作业标题查询
    public List<Work> findAllByTeacher_NameLikeOrWorkDetail_WorkTitleLike(String keywords) {
        return workDao.findAllByTeacher_NameLikeOrWorkDetail_WorkTitleLike('%'
                + keywords + '%','%' + keywords + '%');
    }

    //根据账号查询当前学生
    public List<Work> findAllByStudent_User_Account(String keywords) {
        return workDao.findAllByStudent_User_Account(keywords);
    }

    //根据账号查询
    public List<Work> findAllByTeacher_User_Account(String keywords) {
        return workDao.findAllByTeacher_User_Account(keywords);
    }

    //    通过 id 删除
    public void deleteById(int id) {
        workDao.deleteById(id);
    }

    //    通过  id 查询
    public Work findById(int id){
        return workDao.findById(id);
    }

    public boolean isExist(int id) {
        Work work = findById(id);
        return null!=work;
    }
}
