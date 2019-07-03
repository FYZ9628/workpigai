package com.example.workpigai.controller.admin;

import com.example.workpigai.model.ChoseCourse;
import com.example.workpigai.model.Search;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.ChoseCourseService;
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
public class AdminControllerChoseCourse {

    @Autowired
    ChoseCourseService choseCourseService;


    @GetMapping("/api/choseCourseInfo")
    public List<ChoseCourse> choseCourseList() throws Exception {
        return choseCourseService.choseCourseList();
    }

    @PostMapping("/api/searchChoseCourse")
    public List<ChoseCourse> findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike(@RequestBody Search s)
            throws Exception {

        return choseCourseService.findAllByCourseNameLikeOrTeacher_NameLikeOrMClass_ClassNameLike(s.getKeywords());
    }

    @PostMapping("/api/addChoseCourse")
    public ChoseCourse addChoseCourse(@RequestBody ChoseCourse choseCourse) throws Exception {

        boolean bl = choseCourseService.isExist(choseCourse.getId());
        if (bl == true){
            return null;
        }else {
            choseCourse = choseCourseService.addOrUpdateChoseCourse(choseCourse);
            return choseCourse;
        }
    }

    @PostMapping("/api/updateChoseCourse")
    public ChoseCourse updateChoseCourse(@RequestBody ChoseCourse choseCourse) throws Exception {

        boolean bl = choseCourseService.isExist(choseCourse.getId());
        if (bl == true){
            choseCourse = choseCourseService.addOrUpdateChoseCourse(choseCourse);
            return choseCourse;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteChoseCourse")
    public Result deleteChoseCourse(int id) throws Exception {
        //因为前端只是传了一个 id (序号) 过来，所以 choseCourseId 里面只有一个 id 没有其他信息
        //所以要再通过 id 查询 ChoseCourse 的其他信息
        ChoseCourse choseCourse = choseCourseService.findById(id);
        if (choseCourse != null){
            choseCourseService.deleteById(id);
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }


//    @PostMapping("/api/deleteChoseCourse")
//    public Result deleteChoseCourse(@RequestBody ChoseCourse choseCourseId) throws Exception {
//        //因为前端只是传了一个 id (序号) 过来，所以 choseCourseId 里面只有一个 id 没有其他信息
//        //所以要再通过 id 查询 ChoseCourse 的其他信息
//        ChoseCourse choseCourse = choseCourseService.findById(choseCourseId.getId());
//        if (choseCourse != null){
//            choseCourseService.deleteById(choseCourseId.getId());
//            //   删除成功返回码 100
//            return new Result(100);
//        } else {
//            //   删除失败返回码 400
//            return new Result(400);
//        }
//    }
}
