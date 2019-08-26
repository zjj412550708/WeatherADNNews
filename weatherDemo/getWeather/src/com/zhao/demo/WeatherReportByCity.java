package com.zhao.demo;


import net.sf.json.JSONObject;

public class WeatherReportByCity {
	
	
    public static String excute(String cityName){
     String url="http://v.juhe.cn/weather/index?cityname="+cityName+"&key=a24938e631785f005936769879651e1d";
        return PureNetUtil.get(url);
    }
  
    public static String GetTodayTemperatureByCity(String city) {
    	
        String result=excute(city);

        System.out.println(result);
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            
            result=obj.getString("resultcode");
            
            if(result!=null&&result.equals("200")){
                result=obj.getString("result");
                
                obj=JSONObject.fromObject(result);
                
                result=obj.getString("today");
                obj=JSONObject.fromObject(result);
                
                result=obj.getString("temperature");
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str=GetTodayTemperatureByCity("武汉");
        System.out.println(str);
    	
    }
}
