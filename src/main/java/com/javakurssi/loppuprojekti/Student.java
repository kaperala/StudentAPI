package com.javakurssi.loppuprojekti;

import java.util.UUID;

public class Student {
    private UUID studentID;
    private String firstName = "";
    private String lastName = "";

    public Student(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = UUID.randomUUID();
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " ";
    }
}
