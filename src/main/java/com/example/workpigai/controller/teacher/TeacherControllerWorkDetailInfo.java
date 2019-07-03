package com.example.workpigai.controller.teacher;

import com.example.workpigai.model.Search;
import com.example.workpigai.model.WorkDetail;
import com.example.workpigai.result.Result;
import com.example.workpigai.service.WorkDetailService;
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
public class TeacherControllerWorkDetailInfo {

    @Autowired
    WorkDetailService workDetailService;

    @GetMapping("/api/workDetailInfo")
    public List<WorkDetail> workDetailList() throws Exception {
        return workDetailService.workDetailList();
    }


    @PostMapping("/api/searchWorkDetail")
    public List<WorkDetail> findAllByWorkTitleLike(@RequestBody Search s) throws Exception {

        return workDetailService.findAllByWorkTitleLike(s.getKeywords());
    }


    @PostMapping("/api/addWorkDetail")
    public WorkDetail addWorkDetail(@RequestBody WorkDetail workDetail) throws Exception {

        boolean bl = workDetailService.isExist(workDetail.getId());
        if (bl == true){
            return null;
        }else {
            workDetail = workDetailService.addOrUpdateWorkDetail(workDetail);
            return workDetail;
        }
    }

    @PostMapping("/api/updateWorkDetail")
    public WorkDetail updateWorkDetail(@RequestBody WorkDetail workDetail) throws Exception {

        boolean bl = workDetailService.isExist(workDetail.getId());
        if (bl == true){
            workDetail = workDetailService.addOrUpdateWorkDetail(workDetail);
            return workDetail;
        }else {
            return null;
        }
    }


    @PostMapping("/api/deleteWorkDetail")
    public Result deleteWorkDetail(@RequestBody int id) throws Exception {
        //因为前端只是传了一个 id (序号) 过来
        //所以要再通过 id 查询 Class 的其他信息
        WorkDetail workDetail = workDetailService.findById(id);
        if (workDetail != null){
            workDetailService.deleteById(id);
            //   删除成功返回码 100
            return new Result(100);
        } else {
            //   删除失败返回码 400
            return new Result(400);
        }
    }


}
