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
	private String content; 	// 普通正文
	private String imgContent;  // 图片正文
	private String msgId; 		// 消息顺序ID
	private String msgTeamId;   // 消息所属团队ID

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((imgContent == null) ? 0 : imgContent.hashCode());
		result = prime * result + ((msgId == null) ? 0 : msgId.hashCode());
		result = prime * result
				+ ((msgTeamId == null) ? 0 : msgTeamId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageAPI other = (MessageAPI) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (imgContent == null) {
			if (other.imgContent != null)
				return false;
		} else if (!imgContent.equals(other.imgContent))
			return false;
		if (msgId == null) {
			if (other.msgId != null)
				return false;
		} else if (!msgId.equals(other.msgId))
			return false;
		if (msgTeamId == null) {
			if (other.msgTeamId != null)
				return false;
		} else if (!msgTeamId.equals(other.msgTeamId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessageAPI [content=" + content + ", imgContent=" + imgContent
				+ ", msgId=" + msgId + ", msgTeamId=" + msgTeamId + "]";
	}
	
}
