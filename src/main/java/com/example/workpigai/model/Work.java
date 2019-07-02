package com.example.workpigai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "work")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Work {

    //主键定义，只能有一个，选择对应的列名
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    //对应于外键的名，整个列被外键的对象替换
    //多个作业可以对应一个被发布出来的作业模板
    @ManyToOne
    @JoinColumn(name="work_detail_id")
    private WorkDetail workDetail;


    //对应于外键的名，整个列被外键的对象替换
    //多个作业可以对应多个教师
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;


    //对应于外键的名，整个列被外键的对象替换
    //多个作业可以对应多个教师
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    String submitContent;
    String state;

    String startTime;
    String endTime;
    int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkDetail getWorkDetail() {
        return workDetail;
    }

    public void setWorkDetail(WorkDetail workDetail) {
        this.workDetail = workDetail;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubmitContent() {
        return submitContent;
    }

    public void setSubmitContent(String submitContent) {
        this.submitContent = submitContent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
