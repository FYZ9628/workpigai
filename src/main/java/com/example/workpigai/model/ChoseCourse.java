package com.example.workpigai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "chose_course")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ChoseCourse {

    //主键定义，只能有一个，选择对应的列名
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String courseName;


    //对应于外键的名，整个列被外键的对象替换
    @ManyToOne
    @JoinColumn(name="teacher_id")
    Teacher teacher;


    //对应于外键的名，整个列被外键的对象替换
    @ManyToOne
    @JoinColumn(name="class_id")
    Class mClass;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Class getmClass() {
        return mClass;
    }

    public void setmClass(Class mClass) {
        this.mClass = mClass;
    }
}
