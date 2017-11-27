package pkg;

import java.io.Serializable;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable{
    private String name;
    private String password;
    private String email;
    private ArrayList<Course> courses;
    private HashSet<Document> uploadedDocs;
    private HashSet<Document> viewedDocs;
    private Boolean admin;

    public User(String name, String password, String email, Boolean admin) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.admin = admin;
        //adds admin to Main class' admins/users hashmap
        //Key for each map is unique hashcode
        if (this.admin == true) {
            Main.admins.put(this.hashCode(), this);
        }
        else {
            Main.users.put(this.hashCode(), this);
        }
        this.courses = new ArrayList<Course>();

    }


    @Override
    public int hashCode(){
        return name.hashCode() * password.hashCode() * email.hashCode();
    }

    @Override
    public boolean equals(User o) {
        return o.hashCode() == this.hashCode();

    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    //return admin
    public boolean isAdmin() {
        return this.admin;
    }

    //creates new Course object
    public void newCourse(String name) {
        if (Main.courses.keys().contains(name)) {
            throw new IllegalArgumentException("The page for this course already exists.");
        }
        Course created = new Course(name, this);
        this.courses.add(created);

    }

    //calls the course’s uploadDocument function
    //Ideally, there would be a scroll bar for the user to choose a course that already exists (access list of all courses in Main class)
    public void upLoadDocument(String docName, Document doc, Course course) {
        return course.uploadDocument(this, docName, doc);

    }



 
}
