package pkg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

class Document implements Comparable<Document>, Serializable {
    private User uploader;
    private String name;
    private String docBody;
    private Course course;
    private float ratingTotal; //holds the sum of all ratings
    private HashMap<User, Float> userRatings; //maps a user to the rating they made
    private float numViews; //number of users who have viewed this document
    private HashMap<User, ArrayList<Comment>> comments; //maps user to their ArrayList of comments on the document

    //constructor creates a Document object that holds accompanying info
    //make sure to initialize values for each instance variable
    Document(String docBody, User uploader, String name, Course course) {
        //look at the course class for a reference on how to write a constructor
        /**

         Wendi's code here

         */
    }


    /*
        updates rating instead of making a new rating if the user already made a rating
            subtracts userRating.get(user) from ratingTotal and then adds new rating in
            updates userRatings hashmap with new rating
        otherwise
            maps the user object to the new rating in userRatings
            updates the ratingTotal += rating
     */
    private void addRating(User user, float rating) {
        /**

         Wendi's code here

         */
    }


    /*
    subtracts rating from ratingTotal
    lastly, removes rating and user from userRatings hashmap
     */
    private void removeRating(User user) {
        /**

         Wendi's code here

         */
    }

    //return the uploader's name
    String getUploaderName() {
        /**

         Wendi's code here

         */
    }

    //verifies that the user argument is the uploader User
    Boolean isUploader(User u) {
        return u == uploader;
    }

    //return ratingTotal/(The number of ratings inside userRatings)
    float getAverageRating() {
        /**

         Wendi's code here

         */
    }

    float getNumRatings() {
        return userRatings.size();
    }

    //return numViews
    float getNumViews() {
        /**

         Wendi's code here

         */
    }

    /*
    called by course

    checks if the user’s comment ArrayList is null
    if it is then
        in comments, map the user to a new ArrayList<Comment>
    else
        it gets the ArrayList from comments.get(user) and appends a new Comment object to it

     */
    private void addComment(User user, String comment, Document doc) {
        /**

         Wendi's code here

         */
    }

    /*
    called by course

    checks if the user is authorized to remove a comment
        which means either the user argument is the comment’s user (use the Comment class function isCommenter) or it's a user admin( user.isAdmin() )
        gets the comment array from comments.get(user) and removes the comment at the commentIndex.
    else if the user isn't authorized
        does nothing
     */
    private void removeComment(User user, Document doc, int commentIndex) {
        /**

         Wendi's code here

         */
    }

    public void incrementViews() {
        numViews += 1;
    }

    //used in the PriorityQueue which causes the documents to be compared based on views, with smallest views getting priority
    public int compareTo(Document otherDoc) {
        //ensures the other document is of the right type
        if (!(otherDoc instanceof Document)) {
            throw new ClassCastException("pkg.Document object expected");
        }
        return Math.round(this.numViews - otherDoc.getNumViews());
    }
}
