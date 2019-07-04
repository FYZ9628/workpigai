package com.example.workpigai.service;

import com.example.workpigai.dao.TeacherDao;
import com.example.workpigai.model.Teacher;
import com.example.workpigai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherDao teacherDao;
    @Autowired
    UserService userService;


    public List<Teacher> teacherList() {
        //根据 id 由小到大排序，只能用于数值型数据
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return teacherDao.findAll(sort);
    }


    //添加或更新教师信息
    public Teacher addOrUpTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }


    //根据姓名或账号查询
    public List<Teacher> findAllByNameLikeOrUser_AccountLike(String keywords) {
        return teacherDao.findAllByNameLikeOrUser_AccountLike('%'
                + keywords + '%', '%' + keywords + '%');
    }


    //    通过 id 删除
    public void deleteById(int id) {
        teacherDao.deleteById(id);
    }

    //    通过  id 查询
    public Teacher findById(int id){
        return teacherDao.findById(id);
    }


    //    通过  account 查询
    public Teacher findByUser_Account(String account){
        return teacherDao.findByUser_Account(account);
    }


    //----------------------------------- 暂时没有用到 ------------------------------------------------------

    public List<Teacher> Search(String keywords) {
        return teacherDao.findAllByNameLike('%' + keywords + '%');
    }

    public List<Teacher> searchAllTeacherByUser(User user) {
        return teacherDao.findAllByUser(user);
    }

    public Teacher searchTeacherByUser(User user) {
        return teacherDao.findByUser(user);
    }

    public List<Teacher> findTeachersByUser_Account(String account) {
        return teacherDao.findTeachersByUser_Account(account);
    }

    //----------------------------------- 暂时没有用到 ------------------------------------------------------


}
