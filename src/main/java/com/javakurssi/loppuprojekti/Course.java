package com.javakurssi.loppuprojekti;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public abstract class Course {
    public UUID courseID;
    public String courseName;
    public String courseTeacher;
    public List<Student> courseStudents = new ArrayList<>();

    public Course(String courseName, String courseTeacher) {
        this.courseID = UUID.randomUUID();
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public List<Student> getCourseStudents() {
        return courseStudents;
    }

    public boolean addCourseStudents(Student s) {
        this.courseStudents.add(s);
        return true;
    }

    public Course() {

    }
}
