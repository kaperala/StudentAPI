package com.javakurssi.loppuprojekti;

import java.util.List;
import java.util.UUID;

public interface ICourseService {
    List<Student> getStudents();

    List<Course> getCourses();

    Student getStudentByID(UUID studentID);

    Course getCourseByID(UUID courseID);

    List<Course> getCoursesOfStudent(UUID studentID);

    boolean addStudentToCourse(UUID studentID, UUID courseID);
}
