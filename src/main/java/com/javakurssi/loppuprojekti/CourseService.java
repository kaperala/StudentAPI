package com.javakurssi.loppuprojekti;

import java.util.List;
import java.util.UUID;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CourseService implements ICourseService {

    public List<Student> courseStudents = new ArrayList<>();
    public List<Student> students = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();
    Student s1 = new Student();

    public CourseService() {
        CourseFileService cfs = new CourseFileService();
        try {
            for (Student s : cfs.readStudentsFromFile("./tiedostot/students.txt")) {
                students.add(s);
            }
            for (Course c : cfs.readCoursesFromFile("./tiedostot/courses.txt")) {
                courses.add(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File path invalid");
        }

    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Student getStudentByID(UUID studentID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Course getCourseByID(UUID courseID) {
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> getCoursesOfStudent(UUID studentID) {
        List<Course> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                for (Course c : courses) {
                    if (c.getCourseStudents().contains(s)) {
                        result.add(c);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean addStudentToCourse(UUID studentID, UUID courseID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                for (Course c : courses) {
                    if (c.getCourseID().equals(courseID)) {
                        if (c.addCourseStudents(s) == true) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
