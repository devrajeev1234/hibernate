package klh.exp_4_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("201")
    private int studentId;

    @Value("Anitha")
    private String name;

    private String course;
    private int year;

    @Value("Cloud Computing")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("2024")
    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}

