package com.zheng.controllers.api;

//	                   _ooOoo_
//	                  o8888888o
//	                  88" . "88
//	                  (| -_- |)
//	                  O\  =  /O
//	               ____/`---'\____
//	             .'  \\|     |//  `.
//	            /  \\|||  :  |||//  \
//	           /  _||||| -:- |||||-  \
//	           |   | \\\  -  /// |   |
//	           | \_|  ''\---/''  |   |
//	           \  .-\__  `-`  ___/-. /
//	         ___`. .'  /--.--\  `. . __
//	      ."" '<  `.___\_<|>_/___.'  >'"".
//	     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//	     \  \ `-.   \_ __\ /__ _/   .-` /  /
//	======`-.____`-.___\_____/___.-`____.-'======
//	                   `=---='
//	^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//	         佛祖保佑       永无BUG

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.et.mvc.JsonView;
import com.et.mvc.TextView;
import com.et.mvc.View;
import com.zheng.controllers.ApplicationController;

/**
 * 
 * jsonp控制器
 * 
 * @author shuzheng
 * @version 2015/03/12
 * 
 */
public class JsonpController extends ApplicationController {

	// private static Log log = LogFactory.getLog(HelloController.java.class);

	/**
	 * 首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public View index() throws Exception {
		String action = request.getParameter("callback");
		Map<String, Object> data = new HashMap<String, Object>();
		if (action.equals("getHtml")) {
			String param_url = request.getParameter("url");
			String param_code = request.getParameter("code");
			URL url = new URL(param_url);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), param_code));
			StringBuffer sb = new StringBuffer();
			if(br != null){
	            String s = null;
	            while((s = br.readLine())!=null){
	                sb.append(s + "\n");
	            }
	            br.close();
	        }
			data.put("result", sb.toString());
		}

		return new TextView(action + "(" + new JsonView(data) + ")");
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public View test(String a, String b) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("username", "shuzheng");
		data.put("password", "123456");
		return new JsonView(data);
	}
}
