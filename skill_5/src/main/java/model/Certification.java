package model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 101;
    private String name = "AWS Cloud Practitioner";
    private String dateOfCompletion = "15-Jan-2026";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    @Override
    public String toString() {
        return "Certification [id=" + id + 
               ", name=" + name + 
               ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
