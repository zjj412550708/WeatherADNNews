package com.zhao.demo;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.println("请输入您需要查询的地点:");
    	Scanner input = new Scanner(System.in);
          String city = input.next();
          String city_url = URLEncoder.encode(city, "GBK");
          String link="http://php.weather.sina.com.cn/xml.php?city="+city_url+"&password=DJOYnieT8234jlsK&day=0";  
          
        URL url;  
          
        try {  
              
            url = new URL(link);  
            GetWeather parser = new GetWeather(url);  
            String[] nodes = {"city","status1","temperature1","status2","temperature2"};  
            Map<String, String> map = parser.getValue(nodes);  
            System.out.println(map.get(nodes[0])+" 今天白天："+map.get(nodes[1])+" 最高温度："+map.get(nodes[2])+"℃ 今天夜间："+map.get(nodes[3])+" 最低温度："+map.get(nodes[4])+"℃ ");  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        }  
  
    }  

}
