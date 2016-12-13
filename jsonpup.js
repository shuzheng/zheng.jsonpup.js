/**************************************************************
*	Copyright (c) 2015, Zhang Shuzheng All rights reserved.
*
*	2015-03-12
*
*	作者:张恕征
*
*	主页：http://www.zhangshuzheng.cn/
*
*	邮箱：469741414@qq.com
*
**************************************************************/

/**
 * jsonp抓取远程网址内容：全球首家支持json跨域请求平台
 * @param url
 * @param code
 * @param callback
 * @version 2015/03/12
 */
var JsonpUp =  {
	load : function(url, code, callback) {
		$.ajax({
			data: 'url=' + url + '&code=' + code,
			dataType: "jsonp", 
			jsonp:"callback",
			jsonpCallback : "getHtml",
			url: "http://192.168.1.23:8080/zheng/api/jsonp",
			success: function (json) {
				if (callback && (callback  instanceof Function)) {
					callback(json.result);
				}
			},
			error: function (xhr, status, ex) {
				if (callback && (callback  instanceof Function)) {
					callback('error');
				}
			}
		});
	}
}