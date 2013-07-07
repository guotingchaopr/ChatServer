package com.guotingchao.TaskChat.Server;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

import com.guotingchao.TaskChat.Api.SendMessage;
import com.guotingchao.TaskChat.Servlet.ServerPoolServlet;

/**
 * 
* @ClassName: TaskServerSocket
* @Description: TODO(通讯主程)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2013-7-6 下午10:42:42
*
 */
public class TaskServerSocket implements OnTextMessage {
	private Logger log = Logger.getLogger(TaskServerSocket.class);
	private Connection conn;
	private Long sinceId;
	private Long secret;

	/**
	 * [重载方法]
	 * <p>
	 * Title: onClose
	 * </p>
	 * <p>
	 * Description:当某个连接断开时 触发此方法
	 * </p>
	 * 
	 * @param index
	 * @param name
	 * @see org.eclipse.jetty.websocket.WebSocket#onClose(int, java.lang.String)
	 */
	@Override
	public void onClose(int index, String time) {
		ServerPoolServlet.getTaskServerSocketList().remove(this);
	}

	/**
	 * [重载方法]
	 * <p>
	 * Title: onOpen
	 * </p>
	 * <p>
	 * Description: 当某个连接联通时
	 * </p>
	 * 
	 * @param conn
	 * @see org.eclipse.jetty.websocket.WebSocket#onOpen(org.eclipse.jetty.websocket.WebSocket.Connection)
	 */
	@Override
	public void onOpen(Connection conn) {
		this.conn = conn;
		ServerPoolServlet.getTaskServerSocketList().add(this);
	}

	/**
	 * [重载方法]
	 * <p>
	 * Title: onMessage
	 * </p>
	 * <p>
	 * Description: 当接收到消息时触发
	 * </p>
	 * 
	 * @param message
	 * @see org.eclipse.jetty.websocket.WebSocket.OnTextMessage#onMessage(java.lang.String)
	 */
	@Override
	public void onMessage(String message) {
		new SendMessage(ServerPoolServlet.getTaskServerSocketList(), message);
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Long getSinceId() {
		return sinceId;
	}

	public void setSinceId(Long sinceId) {
		this.sinceId = sinceId;
	}

	public Long getSecret() {
		return secret;
	}

	public void setSecret(Long secret) {
		this.secret = secret;
	}

}
