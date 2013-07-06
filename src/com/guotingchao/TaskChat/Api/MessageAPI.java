/**   
 * @Title: MessageAPI.java
 * @Package com.guotingchao.TaskChat.Api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com   
 * @date 2013-7-6 下午6:05:47
 * @version V1.0   
 */
package com.guotingchao.TaskChat.Api;

/**
 * 
 * @ClassName: MessageAPI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-6 下午6:07:04
 * 
 */
public class MessageAPI extends BaseAPI {
	private String content; // 普通正文
	private String imgContent; // 图片正文
	private String msgId; // 消息顺序ID
	private String msgTeamId; // 消息所属团队ID

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgContent() {
		return imgContent;
	}

	public void setImgContent(String imgContent) {
		this.imgContent = imgContent;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgTeamId() {
		return msgTeamId;
	}

	public void setMsgTeamId(String msgTeamId) {
		this.msgTeamId = msgTeamId;
	}

}
