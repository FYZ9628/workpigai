package com.example.workpigai.controller.admin;

import com.example.workpigai.model.Class;
import com.example.workpigai.model.Search;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class AdminControllerClassInfo {

    @Autowired
    ClassService classService;

    @GetMapping("/api/classInfo")
    public List<Class> classList() throws Exception {
        return classService.classList();
    }


    @PostMapping("/api/searchClass")
    public List<Class> classFindAllByClassIdLikeOrClassNameLike(@RequestBody Search s) throws Exception {

        return classService.findAllByClassIdLikeOrClassNameLike(s.getKeywords());
    }

    @PostMapping("/api/addClass")
    public Class addClass(@RequestBody Class mClass) throws Exception {

        boolean bl = classService.isExist(mClass.getId());
        if (bl == true){
            return null;
        }else {
            mClass = classService.addOrUpdateClass(mClass);
            return mClass;
        }
    }
    @PostMapping("/api/updateClass")
    public Class updateClass(@RequestBody Class mClass) throws Exception {

        boolean bl = classService.isExist(mClass.getId());
        if (bl == true){
            mClass = classService.addOrUpdateClass(mClass);
            return mClass;
        }else {
            return null;
        }
    }

    @PostMapping("/api/deleteClass")
    public Result deleteClass(@RequestBody Class mClassId) throws Exception {
        //因为前端只是传了一个 id (序号) 过来，所以 mClassId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 Class 的其他信息
        Class mClass = classService.findById(mClassId.getId());
        if (mClass != null){
            classService.deleteById(mClassId.getId());
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }
}
