package pkg;

import java.io.Serializable;
import java.util.Date;

class Comment implements Serializable{
    public String comment;
    public User commenter; //person who made the comment
    public Document doc; //the doc this comment was made on
    public Date date;
    public User user;

    //set the instance variables to the arguments
    public Comment(String comment, User user, Document doc) {
        this.comment = comment;
        this.user = user;
        this.doc = doc;
        this.date = new Date();   
    }

    @Override
    public int hashCode() {
        return this.comment.hashCode() * this.user.hashCode();
    }

    @Override
    public boolean equals(Object a) {
        return a.hashCode() == this.hashCode();
    }

}
