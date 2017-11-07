package pkg;

import java.io.Serializable;

class Comment implements Serializable{
    private String comment;
    private User commenter; //person who made the comment
    private Document doc; //the doc this comment was made on

    //set the instance variables to the arguments
    private Comment(String comment, String, User user, Document doc) {
    /**

    Wendi's code here

    */
    }

    //return comment
    private String getComment() {
    /**

    Wendi's code here

    */
    }

    //checks if the user argument is the uploader
    public Boolean isCommenter(User user) {
        return user == commenter;
    }

    //return commenter
    private User getUser() {
    /**

    Wendi's code here

    */
    }

    //return doc
    private Document getDocument() {
    /**

    Wendi's code here

    */
    }
}
