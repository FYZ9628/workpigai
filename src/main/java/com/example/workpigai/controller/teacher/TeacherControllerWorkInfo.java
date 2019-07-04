package com.example.workpigai.controller.teacher;

import com.example.workpigai.result.Search;
import com.example.workpigai.model.Work;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.WorkService;
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
public class TeacherControllerWorkInfo {

    @Autowired
    WorkService workService;

    @GetMapping("/api/workInfo")
    public List<Work> workList() throws Exception {
        return workService.workList();
    }


    @PostMapping("/api/searchWork")
    public List<Work> findAllByTeacher_NameLikeOrWorkDetail_WorkTitleLike(@RequestBody Search s) throws Exception {

        return workService.findAllByTeacher_NameLikeOrWorkDetail_WorkTitleLike(s.getKeywords());
    }


    @PostMapping("/api/addWork")
    public Work addWorkDetail(@RequestBody Work work) throws Exception {

        boolean bl = workService.isExist(work.getId());
        if (bl == true){
            return null;
        }else {
            work = workService.addOrUpdateWork(work);
            return work;
        }
    }

    @PostMapping("/api/updateWork")
    public Work updateWorkDetail(@RequestBody Work work) throws Exception {

        boolean bl = workService.isExist(work.getId());
        if (bl == true){
            work = workService.addOrUpdateWork(work);
            return work;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteWork")
    public Result deleteWork(@RequestBody int id) throws Exception {
        //因为前端只是传了一个 id (序号) 过来
        //所以要再通过 id 查询 Class 的其他信息
        Work workDetail = workService.findById(id);
        if (workDetail != null){
            workService.deleteById(id);
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }


}
