package com.emailReport;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.Reporter;

import com.extent.ExtentReporter;

public class MailReport extends ExtentReporter{
	
	
	
	public  void EmailReport() {
		

		//String filepath = ExtentReporter.screencapture();
		
			
		
		//mailto:gsautomationtester@igs.ind.in
//		// mail extent reports
//		String[] to = { "mailto:mahesh.r@igsindia.net" };
//		String[] cc = {"mailto:kartheek.dn@igsindia.net,jenkinshipi"};
//		String[] bcc = {};

//		sendMail("UserID", "Password", "smtp.gmail.com", "25", "true", "true", true, "javax.net.ssl.SSLSocketFactory",
//				"false", to, cc, bcc, "Automation Fail Alert",
//				"TestCAse ID", "Summary");
	}

	public  boolean sendMail(final String userName, final String passWord, String host, String port,
			String starttls, String auth, boolean debug, String socketFactoryClass, String fallback, String[] to,
			String[] cc, String[] bcc, String subject, String text, String TestcaseSummary) {
		
		
		
		String file = System.getProperty("user.dir") + "/Reports" + "/" + currentDate + "/" + getPlatform() + "/"
				+ Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("userType")
		+ "/" + getReport() + "/Screenshots/" + getReport() + "_" + getDate() + ".jpg";

		Properties props = new Properties();
		System.out.println("Preparing to send email");
		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		//props.put("mail.smtp.ssl.enable", "false");
	//	props.put("mail.smtp.socketFactory.port", port);
		//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	//	props.put("mail.smtp.ssl.trust", "smtpserver");
		//props.put("mail.smtp.tls", false);
		
		
		

		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passWord);
				}
			});

			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject);
			//msg.setText(text);
			//msg.setText(TestcaseSummary);
			
			// attachment start
			// create the message part

			Multipart emailcontent = new MimeMultipart();
			MimeBodyPart textbody = new MimeBodyPart();
			MimeBodyPart attachment = new MimeBodyPart();
			
			textbody.setText(text);
			textbody.setText(TestcaseSummary + " - Failed   ");
			
			attachment.attachFile(new File(file));
			emailcontent.addBodyPart(textbody);
			emailcontent.addBodyPart(attachment);
			
			
//			DataSource source = new FileDataSource(new File(file));
//			messageBodyPart.setDataHandler(new DataHandler(source));
//			messageBodyPart.setFileName(file);
//			messageBodyPart.setContent(msg, "this is from test email");
			
			
			msg.setContent(emailcontent);
			

			// attachment ends
			// Put parts in message
			
			//msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
			}
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
		
			transport.connect(host, userName, passWord);
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("msg sent successFully");
			transport.close();
			return true;
		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
	}
}