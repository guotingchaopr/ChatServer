/**   
 * @Title: UserPojo.java
 * @Package com.guotingchao.TaskChat.Pojo
 * @Description: TODO(User对象)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-13 下午11:44:25
 * @version V1.0   
 */
package com.guotingchao.TaskChat.Pojo;

import java.util.Date;

/**
 * @ClassName: UserPojo
 * @Description: TODO(UserPojo)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2013-7-13 下午11:44:25
 * 
 */
public class UserPojo{
	private Long id;
	private String uname;
	private String upass;
	private int flag;
	private int role;
	private Date create_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
