package com.guotingchao.TaskChat.Servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.guotingchao.TaskChat.Server.TaskServerSocket;

public class InitServerServlet extends HttpServlet {
	private Logger log = Logger.getLogger(InitServerServlet.class);
	private static final long serialVersionUID = 1L;
	private static List<TaskServerSocket> taskServerSocketList;

	@Override
	public void init(ServletConfig config) throws ServletException {
		InitServerServlet.taskServerSocketList = new ArrayList<TaskServerSocket>(); // 初始化Socket接入列表
		super.init(config);
		log.info("服务启动成功 +++++++++" + new Date(System.currentTimeMillis()));
	}

	public static List<TaskServerSocket> getTaskServerSocketList() {
		return taskServerSocketList;
	}

}
