package com.guotingchao.TaskChat.Handle;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.xml.crypto.Data;

import org.apache.log4j.Logger;

import com.alibaba.druid.sql.parser.SQLParser;
import com.guotingchao.TaskChat.MyExceptions.DataException;
import com.guotingchao.TaskChat.Pojo.UserPojo;

/**
 * @Title: DataUtil.java
 * @Package com.guotingchao.TaskChat.Util
 * @Description: TODO(数据自动转换工具类 )
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-13 下午10:29:39
 * @version V1.0
 */
public class DataHandle {
	private static Logger log  = Logger.getLogger(DataHandle.class);
	/**
	 * 
	 * @Title: getResultCollection
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
	public static<T> Collection<Object> getResultCollection(Collection<Object> conn, ResultSet rs,Class<T> clazz) throws DataException, Exception {
		try {
			while (rs.next()) {
				Object vo = clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					String setterMethodName = getSetterMethodName(field.getName());
					Method setterMethod = clazz.getMethod(setterMethodName,field.getType());
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
		Object value = null;
		try {
			 value = rs.getObject(field.getName());
			 if(value.getClass()==BigInteger.class){ //如果是BigInteger 特殊化处理一下 
				 //调试中遇到的问题 不知道是不是最优解决
				 setterMethod.invoke(vo, ((BigInteger)value).longValue());
			 }else{
				 setterMethod.invoke(vo, value);
			 }
			 
		} catch (Exception e) {
			log.error(e.getMessage()+"value: "+value +" valueType:"+value.getClass());
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
	
	public static<T> String ClassDismantle(Class<T> t,String tableName){
		Field[] fields = t.getDeclaredFields();
		StringBuffer fieldsBuffer = new StringBuffer();
		for(Field field: fields){
			fieldsBuffer.append(field.getName()+",");
		}
		return null;
		
	}
	public static void main(String[] args) {
		UserPojo user = new UserPojo();
		DataHandle.ClassDismantle(user.getClass(),"User");
	}
}