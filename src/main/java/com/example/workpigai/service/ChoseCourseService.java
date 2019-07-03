package com.example.workpigai.service;

import com.example.workpigai.dao.ChoseCourseDao;
import com.example.workpigai.dao.WorkDetailDao;
import com.example.workpigai.model.ChoseCourse;
import com.example.workpigai.model.Class;
import com.example.workpigai.model.WorkDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoseCourseService {

    @Autowired
    ChoseCourseDao choseCourseDao;

    public List<ChoseCourse> choseCourseList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return choseCourseDao.findAll(sort);
    }

    //添加或更新选课信息
    public ChoseCourse addOrUpdateChoseCourse(ChoseCourse choseCourse) {
        return choseCourseDao.save(choseCourse);
    }


    //根据课程名称或教师名称或班级名称查询
    public List<ChoseCourse> findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike(String keywords) {
        return choseCourseDao.findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike('%'
                + keywords + '%', '%' + keywords + '%','%' + keywords + '%');
    }


    //    通过 id 删除
    public void deleteById(int id) {
        choseCourseDao.deleteById(id);
    }

    //    通过  id 查询
    public ChoseCourse findById(int id){
        return choseCourseDao.findById(id);
    }

    public boolean isExist(int id) {
        ChoseCourse choseCourse = findById(id);
        return null!=choseCourse;
    }


}
