/**   
* @Title: OnMessage.java
* @Package com.guotingchao.TaskChat.Api
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2013-7-7 上午11:18:44
* @version V1.0   
*/
package com.guotingchao.TaskChat.Api;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.guotingchao.TaskChat.DataSource.DbFactoryDAO;
import com.guotingchao.TaskChat.Pojo.UserPojo;
import com.guotingchao.TaskChat.Server.TaskServerSocket;

/**
 * @ClassName: OnMessage
 * @Description: TODO(发送消息)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-7 上午11:18:44
 * 
 */
public class SendMessage{
	private Logger log = Logger.getLogger(SendMessage.class);
	public List<TaskServerSocket> socketList;
	public SendMessage(List<TaskServerSocket> taskServerSocket,String content){
		socketList = taskServerSocket;
		for (TaskServerSocket socket : socketList) {
			try {
				socket.getConn().sendMessage(DataProcessFactory.ConverJSONMold(content).toString());
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}
	public void sendMessage(Socket socket){
	}
	
	
	public List<TaskServerSocket> getSocketList() {
		return socketList;
	}
	public void setSocketList(List<TaskServerSocket> socketList) {
		this.socketList = socketList;
	}
	
}
