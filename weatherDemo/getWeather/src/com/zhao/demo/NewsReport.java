package com.zhao.demo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NewsReport {
	public static String excute() {
		String url = "http://zhouxunwang.cn/data/?id=75&key=BLrFrIIyGdz+jJqB+oM2T2nBOQTgsJeZ/px16A&type=top";
		return PureNetUtil.get(url);
	}

	public static String GetNewsTop() {

		String result = excute();
		StringBuilder stbu=new StringBuilder();
		//System.out.println(result);
		if (result != null) {
			
			JSONObject obj = JSONObject.fromObject(result);

			    
				result = obj.getString("result");

				obj = JSONObject.fromObject(result);

				result = obj.getString("data");
				JSONArray jsonArray=obj.getJSONArray("data");
				
				for(int j=0;j<jsonArray.size();j++){
					JSONObject jso=jsonArray.getJSONObject(j);
					String title=jso.getString("title");
					String date=jso.getString("date");
					String author_name=jso.getString("author_name");
					String url=jso.getString("url");
					
					String text="<tr>"+"<td>"+title+"</td>"
							+"<td>"+date+"</td>"
							+"<td>"+author_name+"</td>"
							+"<td>"+url+"</td>"+"</tr>";
					stbu.append(text);
					
					
				}
				
				
				
				
				
				
			
		}
		return stbu.toString();
	}

	public static void main(String[] args) {
		String str = GetNewsTop();
		System.out.println(str);

	}

}
