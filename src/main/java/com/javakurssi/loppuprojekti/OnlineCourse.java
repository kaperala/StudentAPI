package com.javakurssi.loppuprojekti;

import java.util.UUID;

public class OnlineCourse extends Course {
    private String courseURL;

    public OnlineCourse(String courseURL, String courseName, String courseTeacher) {
        super.courseID = UUID.randomUUID();
        super.courseName = courseName;
        super.courseTeacher = courseTeacher;
        super.courseStudents = courseStudents;
        this.courseURL = courseURL;
    }

    public String getCourseURL() {
        return courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }

    @Override
    public String toString() {
        return "Kurssi: " + courseName + ", Opettaja: " + courseTeacher + ", Kurssin URL: " + courseURL
                + ", Opiskelijat: " + courseStudents;
    }
}
