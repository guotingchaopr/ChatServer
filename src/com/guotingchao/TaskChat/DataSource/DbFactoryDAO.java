/**   
 * @Title: DbFactoryDAO.java
 * @Package com.guotingchao.TaskChat.DataSource
 * @Description: TODO(数据库操作DAO)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-7 下午4:58:44
 * @version V1.0   
 */
package com.guotingchao.TaskChat.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.guotingchao.TaskChat.Handle.DataHandle;
import com.guotingchao.TaskChat.MyExceptions.DataException;

/**
 * @ClassName: DbFactoryDAO
 * @Description: TODO(数据操作基础DAO)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-7 下午4:58:44
 * 
 */
public  class DbFactoryDAO {
	public static DbPoolConnection dbp;
	static{
		dbp = DbPoolConnection.getInstance(); //只初始化一次
	}
	public static void executeUpdateBySQL(String sql) throws SQLException {
		DruidPooledConnection con = dbp.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		con.close();
	}

	/**
	 * 
	 * @Title: executeQueryBySQL
	 * @Description: TODO(执行查询方法)
	 * @param @param sql
	 * @param @throws SQLException 设定文件
	 * @return Class 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static Collection<Object> executeQueryBySQL(String sql,Class classz) {
		DruidPooledConnection conn = null;
		Collection<Object> c = null;
		ResultSet rs = null;
		try {
			conn = dbp.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			c = DataHandle.getResultCollection(new ArrayList<Object>(), rs, classz);
		} catch (DataException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataHandle.colseAll(conn,rs);
		}
		return c;
	}
}
