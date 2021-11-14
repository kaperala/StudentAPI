package com.javakurssi.loppuprojekti;

import java.util.UUID;

public class LocalCourse extends Course {
    public String courseRoom;

    public LocalCourse(String courseRoom, String courseName, String courseTeacher) {
        super.courseID = UUID.randomUUID();
        super.courseName = courseName;
        super.courseTeacher = courseTeacher;
        super.courseStudents = courseStudents;
        this.courseRoom = courseRoom;
    }

    public String getcourseRoom() {
        return courseRoom;
    }

    public void setcourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    @Override
    public boolean addCourseStudents(Student s) {
        if (this.courseStudents.size() < 2) {
            courseStudents.add(s);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Kurssi: " + courseName + ", Opettaja: " + courseTeacher + ", Huone: " + courseRoom + ", Opiskelijat: "
                + courseStudents;
    }
}
