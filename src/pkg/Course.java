package pkg;

import java.io.Serializable;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.io.File;


class Course implements Serializable {
    //name of course; person who created the course repo
    public String name;
    public User creator;
    //holds the documents sorted by views
    public PriorityQueue<Document> docPQ;
    public HashMap<String, Document> docDict;


    //constructor
    public Course(String name, User creator) {
        this.name = name;
        //adds course to Main class' hashmap
        Main.courses.put(this.name, this);
        this.creator = creator;
        this.docPQ = new PriorityQueue<Document>() {
            public int compare(Document doc1, Document doc2) {
                return doc2.UserRatings.compareTo(doc1.UserRatings);
            }
        };
        this.docDict = new HashMap<String, Document>();
    }

    //called by User object
    //store as File object or something else?
    public void uploadDocument(User user, String docName) {

        File file = new File(docName);

        //ensures no document has the same name
        if (!docDict.containsKey(docName)) {
            Document doc = new Document(file, user, docName, this);
            this.docDict.put(docName, doc);
            this.docPQ.add(doc);
        } else {
            throw new IllegalArgumentException("A document with this name already exists!");
        }


    }
}





