/**   
* @Title: DataProcessFactory.java
* @Package com.guotingchao.TaskChat.Api
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2013-7-7 下午1:34:20
* @version V1.0   
*/
package com.guotingchao.TaskChat.Api;

import com.google.gson.Gson;

/**
 * @ClassName: DataProcessFactory
 * @Description: TODO(数据处理)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-7 下午1:34:20
 * 
 */
public class DataProcessFactory {
	public static MessageAPI ConverJSONMold(String content){
		Gson gson  = new Gson();
		MessageAPI ma =gson.fromJson(content, MessageAPI.class);
		return ma;
	}
}
