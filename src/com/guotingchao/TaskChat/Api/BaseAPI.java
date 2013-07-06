/**   
 * @Title: BaseAPI.java
 * @Package com.guotingchao.TaskChat.Api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com   
 * @date 2013-7-6 下午5:01:35
 * @version V1.0   
 */
package com.guotingchao.TaskChat.Api;

import java.util.Date;

/**
 * 
 * @ClassName: BaseAPI
 * @Description: TODO(基础API )
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-6 下午7:27:14
 * 
 */
public class BaseAPI {
	private Long token;	 	// 验证令牌 存储在session中
	private int type; 		// 消息类型
	private Date timeStamp; // 时间戳
	private boolean flag;	 // 临时标识

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
