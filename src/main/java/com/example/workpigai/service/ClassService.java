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

    //添加或更新班级信息
    public Class addOrUpdateClass(Class mClass) {
        return classDao.save(mClass);
    }

    //根据班级号或班级名称查询
    public List<Class> findAllByClassIdLikeOrClassNameLike(String keywords) {
        return classDao.findAllByClassIdLikeOrClassNameLike('%'
                + keywords + '%', '%' + keywords + '%');
    }

    //    通过 id 删除
    public void deleteById(int id) {
        classDao.deleteById(id);
    }

    //    通过  id 查询
    public Class findById(int id){
        return classDao.findById(id);
    }

    public boolean isExist(int id) {
        Class mClass = findById(id);
        return null!=mClass;
    }


}
