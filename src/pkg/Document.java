package pkg;

import java.io.Serializable;
import java.io.File;
import java.util.PriorityQueue;
import java.util.Date;


class Document implements Serializable {
    public User uploader;
    public String name;
    public File file;
    public Course course;
    public Double UserRatings; //running average of user ratings
    public Double countRatings; //counts how many ratings there are
    public PriorityQueue<Comment> comments; //comments sorted by date

    //constructor creates a Document object that holds accompanying info
    //make sure to initialize values for each instance variable
    public Document(File file, User uploader, String name, Course course) {
        
        this.file = file;
        this.uploader = uploader;
        this.name = name;
        this.course = course;
        this.comments = new PriorityQueue<Comment>() {
            public int compare(Date date1, Date date2) {
                return date1.compareTo(date2);
            }
        };
        this.countRatings = 0.0;
        this.UserRatings = 0.0;
    }

    // ratings range from 1 to 5 (scroll bar in frontend)
    public void addRating(float rating) {
        this.countRatings += 1;
        this.UserRatings = (this.UserRatings + rating) / this.countRatings;
        evaluate();
        
    }

    public void evaluate() {
        //if a document receives too many bad ratings, send email to uploader
        //to fix it and upload again
        //automatically removes document from database
        if (this.countRatings > 3 && this.UserRatings < 0.5) {

            ratingsEmail.recipient = this.uploader;
            ratingsEmail.email = this.uploader.getEmail();
            ratingsEmail.fileName = this.name;
            ratingsEmail.course = this.course;
            ratingsEmail.count = this.countRatings;
            ratingsEmail.avg = this.UserRatings;

            ratingsEmail.main(null);
            this.course.docPQ.remove(this);
            this.course.docDict.remove(this.name);
        }
    }


    private void addComment(User user, String comment, Document doc) {
        Comment curr = new Comment(comment, user, doc);
        this.comments.add(curr);
        
    }

    private void removeComment(Comment com, User u) {
        
    		if (com.commenter.equals(u) || u.isAdmin()) {
    			this.comments.remove(com);
        }
    		else {
    			throw new IllegalArgumentException("You are not authorized to remove this comment.");
    		}
    }
    
}
