package com.crunchify.restjersey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendEmailClient {
	private static Logger log = Logger.getLogger(SendEmailClient.class.getName());
	
	private SendEmailClient () {
		
	}
	public static void sendToClients() {
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.comcast.net");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(JGConstants.getUsername(), JGConstants.getPassword());
			}
		});

		BufferedReader br = null;
		FileReader fr = null;
		StringBuilder sb = new StringBuilder();
		try {

		br = new BufferedReader(fr);

		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {
			log.info(sCurrentLine);
			sb.append(sCurrentLine);
			sb.append(",");
		}
		StringTokenizer st = new StringTokenizer(sb.toString(),",");
		String currentValue ;

			while (st.hasMoreElements() ) {
				currentValue = (String) st.nextElement() ; 
				log.info(currentValue );
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(JGConstants.getEmailaddress() ) ) ;
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(currentValue));
			message.setSubject(JGConstants.getEmailsubject());
			message.setText(JGConstants.getEmailsubject());

			Transport.send(message);
			}
		}
			catch (FileNotFoundException fnfe) {
				log.error("Caught FileNotFound Excpetion!", fnfe);

			} catch (AddressException ae) {
				log.error("Caught Address Exception!", ae);
			} catch (MessagingException me) {
				log.error("Caught MessagingException!", me);
			} catch (IOException ioe) {
				log.error("Caught IOException!", ioe);
			}
			log.info("All Done");	

	}	

}
