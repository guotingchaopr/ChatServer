package com.guotingchao.TaskChat.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import com.guotingchao.TaskChat.MyExceptions.DataException;

/**
 * @Title: DataUtil.java
 * @Package com.guotingchao.TaskChat.Util
 * @Description: TODO(数据自动转换工具类 )
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-13 下午10:29:39
 * @version V1.0
 */
public class DataUtil {
	/**
	 * 
	 * @Title: getDatas
	 * @Description: TODO(将ResultSet中的值封装成一个集合)
	 * @param @param result
	 * @param @param rs
	 * @param @param clazz
	 * @param @return
	 * @param @throws DataException
	 * @param @throws Exception 设定文件
	 * @return Collection 返回类型
	 * @throws
	 */
	public static Collection getDatas(Collection conn, ResultSet rs,
			Class clazz) throws DataException, Exception {
		try {
			while (rs.next()) {
				// 创建类的实例
				Object vo = clazz.newInstance();
				// 获取本对象的属性
				Field[] fields = clazz.getDeclaredFields();
				// 获取父类的属性
				// Field[] superFields =
				// clazz.getSuperclass().getDeclaredFields();
				// //父类的属性和自己的属性相加
				// Field[] allFields = addFields(superFields, fields);
				// 遍历所有的属性
				for (Field field : fields) {
					// 获得setter方法的方法名
					String setterMethodName = getSetterMethodName(field
							.getName());
					// 获得setter方法
					Method setterMethod = clazz.getMethod(setterMethodName,
							field.getType());
					invokeMethod(rs, field, vo, setterMethod);
				}
				conn.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			new DataException(e.getMessage());
		}
		return conn;
	}

	/**
	 * 
	 * @Title: invokeMethod
	 * @Description: TODO(invokeMethod)
	 * @param @param rs
	 * @param @param field
	 * @param @param vo
	 * @param @param setterMethod 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private static void invokeMethod(ResultSet rs, Field field, Object vo,
			Method setterMethod) {
		try {
			// 当使用ResultSet获取某个字段的时候, 如果没有该字段, 会出现SQLException, 在这里忽略该异常
			String value = rs.getString(field.getName());
			// 从ResultSet中获取与该对象属性名一致的字段, 并执行setter方法
			setterMethod.invoke(vo, value);
		} catch (Exception e) {
			// 忽略异常
		}
	}

	/**
	 * 
	 * @Title: getSetterMethodName
	 * @Description: TODO(根据字段set)
	 * @param @param fieldName
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private static String getSetterMethodName(String fieldName) {
		String begin = fieldName.substring(0, 1).toUpperCase();
		String end = fieldName.substring(1, fieldName.length());
		String methodName = "set" + begin + end;
		return methodName;
	}
	/**
	 * 
	* @Title: colseAll
	* @Description: TODO(通用关闭数据库连接)
	* @param @param conn
	* @param @param rs    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void colseAll(Connection conn,ResultSet rs){
		try {
			if(rs!=null && !rs.isClosed()){
				rs.close();
			}
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}