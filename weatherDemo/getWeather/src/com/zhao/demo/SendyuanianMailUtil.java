/*package com.zhao.demo;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendyuanianMailUtil {
	 public boolean sendTextMail(MailSenderInfo mailInfo) {    
	      // 判断是否需要身份认证    
	      MyAuthenticator authenticator = null;    
	      Properties pro = mailInfo.getProperties();   
	      if (mailInfo.isValidate()) {    
	      // 如果需要身份认证，则创建一个密码验证器    
	        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());    
	      }   
	      // 根据邮件会话属性和密码验证器构造一个发送邮件的session    
	      Session sendMailSession = null;
	       
	       
	      //sendMailSession = Session.getDefaultInstance(pro,authenticator); //获取默认可能报错
	      sendMailSession = Session.getInstance(pro,authenticator);//新创建一个session
	      if (sendMailSession==null){
	         System.out.println("无法获取邮件邮件Session");
	      }
	      try {    
	      // 根据session创建一个邮件消息    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      // 创建邮件发送者地址    
	      Address from = new InternetAddress(mailInfo.getFromAddress()); 
	      // 设置邮件消息的发送者    
	      mailMessage.setFrom(from); 
	      // 创建邮件的接收者地址，并设置到邮件消息中
	      Address to = new InternetAddress(mailInfo.getToAddress()); 
	       
	      mailMessage.setRecipient(Message.RecipientType.TO,to);
	       
	      // 设置邮件消息的主题    
	      mailMessage.setSubject(mailInfo.getSubject());    
	      // 设置邮件消息发送的时间    
	      mailMessage.setSentDate(new Date());    
	      // 设置邮件消息的主要内容    
	      String mailContent = mailInfo.getContent();    
	      mailMessage.setText(mailContent);    
	      
	       
	       
	      //添加附件
//	      if(mailInfo.getAttachFileNames()!=null || mailInfo.getAttachFileNames().length>0){
//	          Multipart mp = new MimeMultipart();  
//	          MimeBodyPart mbp=null;
//	          for(String fileName:mailInfo.getAttachFileNames()){
//	              mbp=new MimeBodyPart();
//	              FileDataSource fds=new FileDataSource(fileName); //得到数据源  
//	              mbp.setDataHandler(new DataHandler(fds)); //得到附件本身并至入BodyPart  
//	              mbp.setFileName(fds.getName());  //得到文件名同样至入BodyPart  
//	              mp.addBodyPart(mbp);  
//	          }
//	          mailMessage.setContent(mp);
//	      }
	       
	      // 发送邮件    
	      Transport.send(mailMessage);   
	      return true;    
	      } catch (MessagingException ex) {    
	          ex.printStackTrace();
	           
	      }    
	      return false;    
	    }    
	    public class MailSenderInfo {    
	    // 发送邮件的服务器的IP和端口    
	    private String mailServerHost;    
	    private String mailServerPort = "25";    
	    // 邮件发送者的地址    
	    private String fromAddress;    
	    // 邮件接收者的地址    
	    private String toAddress;    
	    // 登陆邮件发送服务器的用户名和密码    
	    private String userName;    
	    private String password;    
	    // 是否需要身份验证    
	    private boolean validate = false;    
	    // 邮件主题    
	    private String subject;    
	    // 邮件的文本内容    
	    private String content;    
	    // 邮件附件的文件名    
	    private String[] attachFileNames;     
	     
	    //邮件抄送人
	     
	    private List<String> ccUserList;
	    *//** *//**   
	      * 获得邮件会话属性   
	      *//*    
	    public Properties getProperties(){    
	      Properties p = new Properties();    
	      p.put("mail.smtp.host", this.mailServerHost);    
	      p.put("mail.smtp.port", this.mailServerPort);    
	      p.put("mail.smtp.auth", validate ? "true" : "false");    
	      return p;    
	    }    
	    public String getMailServerHost() {    
	      return mailServerHost;    
	    }    
	    public void setMailServerHost(String mailServerHost) {    
	      this.mailServerHost = mailServerHost;    
	    }   
	    public String getMailServerPort() {    
	      return mailServerPort;    
	    }   
	    public void setMailServerPort(String mailServerPort) {    
	      this.mailServerPort = mailServerPort;    
	    }   
	    public boolean isValidate() {    
	      return validate;    
	    }   
	    public void setValidate(boolean validate) {    
	      this.validate = validate;    
	    }   
	    public String[] getAttachFileNames() {    
	      return attachFileNames;    
	    }   
	    public void setAttachFileNames(String[] fileNames) {    
	      this.attachFileNames = fileNames;    
	    }   
	    public String getFromAddress() {    
	      return fromAddress;    
	    }    
	    public void setFromAddress(String fromAddress) {    
	      this.fromAddress = fromAddress;    
	    }   
	    public String getPassword() {    
	      return password;    
	    }   
	    public void setPassword(String password) {    
	      this.password = password;    
	    }   
	    public String getToAddress() {    
	      return toAddress;    
	    }    
	    public void setToAddress(String toAddress) {    
	      this.toAddress = toAddress;    
	    }    
	    public String getUserName() {    
	      return userName;    
	    }   
	    public void setUserName(String userName) {    
	      this.userName = userName;    
	    }   
	    public String getSubject() {    
	      return subject;    
	    }   
	    public void setSubject(String subject) {    
	      this.subject = subject;    
	    }   
	    public String getContent() {    
	      return content;    
	    }   
	    public void setContent(String textContent) {    
	      this.content = textContent;    
	    }
	    public List<String> getCcUserList(){
	        return ccUserList;
	    }
	    public void setCcUserList(List<String> ccUserList){
	        this.ccUserList = ccUserList;
	    }    
	     
	     
	}   
	 
	public static void main(String[] args) {
	        // 这个类主要是设置邮件
	        MailSenderInfo mailInfo = new MailSenderInfo();
	        mailInfo.setMailServerHost("smtp.163.com");
	        mailInfo.setMailServerPort("25");
	        mailInfo.setValidate(true);
	        mailInfo.setUserName("zhengzhanzong@163.com");
	        mailInfo.setPassword("zzzong0828");// 您的邮箱密码
	        mailInfo.setFromAddress("");
	        //接受方信息
	        mailInfo.setToAddress("");
	        mailInfo.setSubject("邮箱标题 ");
	        mailInfo.setContent("设置邮箱内容 如http://www.guihua.org 中国桂花网 是中国最大桂花网站==");
	         
	        String[] files=new String[]{"D:/1.txt","D:/2.txt","D:/3.txt"};
	        mailInfo.setAttachFileNames(files);
	        // 这个类主要来发送邮件
	        SimpleMailSender sms = new SimpleMailSender();
	        sms.sendTextMail(mailInfo);// 发送文体格式
	        //sms.sendHtmlMail(mailInfo);// 发送html格式
	    }


}
*/