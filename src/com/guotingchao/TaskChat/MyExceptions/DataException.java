/**   
* @Title: sd.java
* @Package com.guotingchao.TaskChat.MyExceptions
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2013-7-13 下午10:34:14
* @version V1.0   
*/
package com.guotingchao.TaskChat.MyExceptions;


/**
 * @ClassName: DataException
 * @Description: TODO(自封装数据异常处理方法) 待完善
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-13 下午10:34:14
 * 
 */
 
public class DataException extends Exception{
	/**
	* @Fields serialVersionUID : TODO(序列化ID)
	*/
	private static final long serialVersionUID = 1L;

	public DataException(String message){
		super();
		System.err.println(message);
	}
} 