package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 1;
    private String name = "Krithik";
    private String gender = "Male";

    @Autowired
    private Certification certification;

    public void displayDetails() {
        System.out.println("Student Id: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Certification Details: " + certification);
    }
}