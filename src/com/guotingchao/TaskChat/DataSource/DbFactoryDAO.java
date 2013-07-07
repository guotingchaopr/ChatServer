/**   
 * @Title: DbFactoryDAO.java
 * @Package com.guotingchao.TaskChat.DataSource
 * @Description: TODO(用一句话描述该文件做什么)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-7 下午4:58:44
 * @version V1.0   
 */
package com.guotingchao.TaskChat.DataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidPooledConnection;

/**
 * @ClassName: DbFactoryDAO
 * @Description: TODO(数据操作基础DAO)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-7 下午4:58:44
 * 
 */
public class DbFactoryDAO {
	public static void executeUpdateBySQL(String sql) throws SQLException {
		DbPoolConnection dbp = DbPoolConnection.getInstance();
		DruidPooledConnection con = dbp.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		con.close();
		dbp = null;
	}
}
