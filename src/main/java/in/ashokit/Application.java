package in.ashokit;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import in.ashokit.service.EmailService;

@SpringBootApplication
public class Application {

	@Autowired
	private EmailService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
					
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException
	{ 
		service.sendEmailWithAttachment("sarfrazprogrammer@gmail.com", "hii", "java develper", "D:\\Sarfaraz resume.pdf");
	}
	
}
