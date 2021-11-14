package com.javakurssi.loppuprojekti;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController

public class MyController {
    CourseService courseService = new CourseService();

    @GetMapping("students")
    public List<Student> getStudents() {
        return courseService.getStudents();
    }

    @GetMapping("students/{studentID}")
    public String getStudentByID(@PathVariable String studentID) {
        UUID uid = UUID.fromString(studentID);
        Student s = courseService.getStudentByID(uid);
        List<Course> coursesOfStudent = courseService.getCoursesOfStudent(uid);
        String response = "<h1>" + s + "</h1><br>";
        if (coursesOfStudent != null) {
            for (Course c : coursesOfStudent) {
                response += "<b>" + c.getCourseName() + "</b><br>";
            }
        } else {
            response = "The student is not in any course";
        }
        return response;
    }

    @GetMapping("courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("courses/{courseID}")
    public String getCourseByID(@PathVariable String courseID) {
        UUID uid = UUID.fromString(courseID);
        Course c = courseService.getCourseByID(uid);
        String response = c.getCourseName() + "<br>";
        for (Student s : c.getCourseStudents()) {
            response += "<b>" + s + "</b><br>";
        }
        return response;
    }

    @GetMapping("onlinecourses")
    public String getOnlineCourses() {
        String response = "";

        for (Course c : courseService.getCourses()) {
            if (c.getClass().getName() == "com.javakurssi.loppuprojekti.OnlineCourse") {
                response += "<b>" + c.getCourseName() + "</b> <br>";
            }
        }
        return response;
    }

    @PostMapping("add")
    public String addStudentToCourse(@RequestBody Map<String, Object> json) {
        UUID studentID = UUID.fromString(json.get("sid").toString());
        UUID courseID = UUID.fromString(json.get("cid").toString());
        Student s = courseService.getStudentByID(studentID);
        Course c = courseService.getCourseByID(courseID);
        String courseName = c.getCourseName();

        courseService.addStudentToCourse(studentID, courseID);

        String response = s + " --> " + courseName;
        return response;
    }
}
