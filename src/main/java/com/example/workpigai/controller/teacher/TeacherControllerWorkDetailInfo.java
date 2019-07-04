package com.example.workpigai.controller.teacher;

import com.example.workpigai.model.*;
import com.example.workpigai.model.Class;
import com.example.workpigai.result.Search;
import com.example.workpigai.result.Result;
import com.example.workpigai.result.PublishWork;
import com.example.workpigai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 控制层  转发调用
 */

@RestController
public class TeacherControllerWorkDetailInfo {

    @Autowired
    WorkDetailService workDetailService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;
    @Autowired
    WorkService workService;


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


    @PostMapping("/api/publishWork")
    public Result publishWork(@RequestBody PublishWork publishWork) throws Exception {

        List<Student> studentList = studentService.findAllByMClass_Id(publishWork.getClassId());
        if (studentList.size() == 0){
            return null;
        }else {
            WorkDetail workDetail = new WorkDetail();
            workDetail.setWorkTitle(publishWork.getWorksDetailWorkTitle());
            workDetail.setPublishContent(publishWork.getWorksDetailPublishContent());
            workDetail.setAnswer(publishWork.getWorksDetailAnswer());
            workDetailService.addOrUpdateWorkDetail(workDetail);

            Teacher teacher = teacherService.findById(publishWork.getTeacherId());

            Date date = new Date();
            SimpleDateFormat startTime=new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
//        System.out.println(startTime.format(date));

            for (int i = 0; i < studentList.size(); i++) {
                Work work = new Work();
                work.setWorkDetail(workDetail);
                work.setTeacher(teacher);
                work.setState("未提交");
                work.setSubmitContent("发布测试");
                work.setStartTime(startTime.format(date));
//        work.setEndTime(publishWork.getEndTime());  //时间格式不对
                work.setEndTime(startTime.format(date));
                work.setStudent(studentList.get(i));
                workService.addOrUpdateWork(work);
            }
            return new Result(100);
        }
    }

}
