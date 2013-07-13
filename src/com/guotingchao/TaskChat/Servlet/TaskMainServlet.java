/**   
* @Title: TaskMainServlet.java
* @Package com.guotingchao.TaskChat.Servlet
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com   
* @date 2013-7-4 下午8:22:18
* @version V1.0   
*/
package com.guotingchao.TaskChat.Servlet;

import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import com.guotingchao.TaskChat.DataSource.DbFactoryDAO;
import com.guotingchao.TaskChat.Pojo.UserPojo;
import com.guotingchao.TaskChat.Server.TaskServerSocket;

/**
 * 
* @ClassName: TaskMainServlet
* @Description: TODO(TaskSocket分发servlet)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2013-7-6 下午10:43:11
*
 */
public class TaskMainServlet extends WebSocketServlet{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(TaskMainServlet.class);
	/**
	 * [重载方法]
	 * <p>Title: doWebSocketConnect</p>
	 * <p>Description: </p>
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see org.eclipse.jetty.websocket.WebSocketFactory.Acceptor#doWebSocketConnect(javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, String args) {
		Collection<Object> c = null;
		c = DbFactoryDAO.executeQueryBySQL("select * from user",UserPojo.class);
		for(Object u : c){
			UserPojo user = (UserPojo)u;
			System.out.println(user.getUname());
			System.out.println(user.getCreate_time());
		}
		return new TaskServerSocket();
	}
}

