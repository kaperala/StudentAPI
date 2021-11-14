package com.javakurssi.loppuprojekti;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseFileService implements ICourseFileService {

    public CourseFileService() {

    }

    @Override
    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] studentInfo = sc.nextLine().split("---");
                Student s = new Student(studentInfo[0], studentInfo[1]);
                students.add(s);
            }
            sc.close();

            return students;
        } catch (FileNotFoundException E) {
            System.out.println("File path invalid");
            return null;
        }
    }

    @Override
    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        List<Course> courses = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] coursesInfo = sc.nextLine().split("---");
                if (coursesInfo.length == 4) {
                    courses.add(new OnlineCourse(coursesInfo[2], coursesInfo[0], coursesInfo[1]));
                } else {
                    courses.add(new LocalCourse(coursesInfo[2], coursesInfo[0], coursesInfo[1]));
                }
            }
            sc.close();

            return courses;
        } catch (FileNotFoundException E) {
            System.out.println("File path invalid");
            return null;
        }
    }

}
