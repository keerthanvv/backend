package com.kohinoor_multi_agency.email;

public class MailRequest {
	
		private String name;
		
		private String mailFrom;
		
	    private String mailTo;
	 
	    private String mailSubject;
	 
	    private String mailContent;
	 
	    private String contentType;
	 
	    public MailRequest() {
	        contentType = "text/plain";
	    }
	    
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMailFrom() {
			return mailFrom;
		}

		public void setMailFrom(String mailFrom) {
			this.mailFrom = mailFrom;
		}

		public String getMailTo() {
			return mailTo;
		}

		public void setMailTo(String mailTo) {
			this.mailTo = mailTo;
		}

		public String getMailSubject() {
			return mailSubject;
		}

		public void setMailSubject(String mailSubject) {
			this.mailSubject = mailSubject;
		}

		public String getMailContent() {
			return mailContent;
		}

		public void setMailContent(String mailContent) {
			this.mailContent = mailContent;
		}

		public String getContentType() {
			return contentType;
		}

		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		
}
