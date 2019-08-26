package com.zhao.demo;

import java.io.IOException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendQQMailUtil {
	public static void main(String[] args) throws AddressException, MessagingException {
		//String str = WeatherReportByCity.GetTodayTemperatureByCity("武汉");
		String str=NewsReport.GetNewsTop();
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");// 连接协议
		properties.put("mail.smtp.host", "smtp.yuanian.com");// 主机名
		properties.put("mail.smtp.port", 25);// 端口号
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
		properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
		
		// 得到回话对象
		Session session = Session.getInstance(properties);
		// 获取邮件对象
		Message message = new MimeMessage(session);
		// 设置发件人邮箱地址
		message.setFrom(new InternetAddress("zhaojj@yuanian.com"));
		// 设置收件人邮箱地址
		message.setRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress("wangyq@yuanian.com"),
				new InternetAddress("qiugch@yuanian.com"), new InternetAddress("wangmh@yuanian.com") });
		/*message.setRecipient(Message.RecipientType.TO, new
		InternetAddress("412550708@qq.com"));//一个收件人
*/		// 设置邮件标题
		message.setSubject("新闻头条   技术开发部赵俊杰");
		// 设置邮件内容
		//message.setText(str);
		String event1 = "新闻资讯：";
		message.setContent(event1+"<table border=\\\"5\\\" style=\\\"border:solid 1px #E8F2F9;font-size=14px;;font-size:18px;>" +
		        "<tr style=\\\"background-color: #428BCA; color:#ffffff\\\"><th>标题</th><th>时间</th><th>作者</th><th>访问链接</th></tr>" +
		        str +
		        "</table>","text/html; charset=utf-8");
		
		// 得到邮差对象
		Transport transport = session.getTransport();
		// 连接自己的邮箱账户
		transport.connect("zhaojj@yuanian.com", "666666@noah");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
		// 发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

}
