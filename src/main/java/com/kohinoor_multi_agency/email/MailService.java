package com.kohinoor_multi_agency.email;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
 
@Service
public class MailService {
	
	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration config;
	
	public MailResponse sendEmail(MailRequest request, Map<String,Object> model) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
			
			Template t =config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			
			helper.setTo(request.getMailTo());
			helper.setText(html , true);
			helper.setSubject(request.getMailSubject());
			helper.setFrom(request.getMailFrom());
			sender.send(message);
			
			response.setMessage("mail send to: " + request.getMailTo());
			response.setStatus(Boolean.TRUE);
		
		
		} catch (MessagingException|IOException|TemplateException e) {
			response.setMessage("Mail Sending failure : "+ e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}
	
	
}