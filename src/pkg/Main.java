package pkg;


// Main Storage //

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

public class Main implements Serializable{

	public static HashMap<String, Course> courses = new HashMap<String, Course>();
	public static HashMap<Integer, User> admins = new HashMap<Integer, User>();
	public static HashMap<Integer, User> users = new HashMap<Integer, User>();

}