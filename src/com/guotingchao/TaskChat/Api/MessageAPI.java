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
public class MessageAPI extends BaseAPI{
	private String content;			//普通正文
	private String base64_content;  //图片正文
	private String msgId; 			//消息顺序ID
	private String msgTeamId; 		//消息所属团队ID
}
