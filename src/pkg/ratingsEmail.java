package pkg;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ratingsEmail {

	public static User recipient;
	public static String email;
	public static String fileName;
	public static Course course;
	public static Double count;
	public static Double avg;



	public static void main(String [] args) {
		String to = email;
		String from = "lauren.hong@berkeley.edu";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("[EECS Course Public Repo] Document Deletion Notice");
			message.setText("Hello " + recipient.getName() + "!" + "Unfortunately," +
				"the document you uploaded to " + course.name + ", " + fileName +
				", " + "received an average rating of " + avg + "accumulated from " + count
				+ " users. We have removed the document, but encourage you to fix any mistakes and" +
				"contribute your notes again!");
			Transport.send(message);
		} catch (javax.mail.MessagingException err) { }
	}

}