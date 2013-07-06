package com.guotingchao.TaskChat.Server;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

import com.guotingchao.TaskChat.Servlet.InitServerServlet;

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
	private Long userid;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public TaskServerSocket(Long userId) {
		this.userid = userId;
	}

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
		InitServerServlet.getTaskServerSocketList().remove(this);
		log.info(this.userid+" 断开：" + time);
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
		log.info("新用户" +this.userid +"接入");
		this.conn = conn;
		InitServerServlet.getTaskServerSocketList().add(this);
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
		List<TaskServerSocket> socketList = InitServerServlet
				.getTaskServerSocketList();
		for (TaskServerSocket socket : socketList) {
			try {
				socket.getConn().sendMessage(this.userid+" 说:"+message);
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
}
