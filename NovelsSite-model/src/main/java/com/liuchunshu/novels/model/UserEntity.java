package com.liuchunshu.novels.model;

import java.io.Serializable;

import com.liuchunshu.novels.enums.RoleEnum;
import com.liuchunshu.novels.enums.UserSexEnum;

public class UserEntity implements Serializable{

	private static final long serialVersionUID = 4755443251668250964L;
	private int userid;
	private String username;
	private String password;
	private UserSexEnum gender;
	private RoleEnum role;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserSexEnum getGender() {
		return gender;
	}

	public void setGender(UserSexEnum gender) {
		this.gender = gender;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "username:"+this.username+",password:"+this.password+",gender:"+gender.getName()+",role:"+this.role.getName();
	}
}
