package in.ashokit.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	/*
	 * public void sendSimpleEmail(String toEmail, String toBody,String subject) {
	 * 
	 * SimpleMailMessage message= new SimpleMailMessage();
	 * message.setFrom("mdsarfrazahmad852131@gmail.com"); message.setTo(toEmail);
	 * message.setText(toBody); message.setSubject(subject);
	 * 
	 * mailsender.send(message); System.out.println("mail send............."); }
	 */
	 
	
	public void sendEmailWithAttachment(String toEmail,String tobody,String subject,String attachment) throws MessagingException
	{
		MimeMessage MimeMessage = mailsender.createMimeMessage();
		
         
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(MimeMessage, true);
		
		mimeMessageHelper.setFrom("mdsarfrazahmad852131@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(tobody);
		mimeMessageHelper.setSubject(subject);

		FileSystemResource fileResource= new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileResource.getFilename(),fileResource);
		
		mailsender.send(MimeMessage);
		System.out.println("mail attachments completed.............");		
		
		
	}
}