package com.liuchunshu.novels.service;

import java.util.List;

import com.liuchunshu.novels.model.UserEntity;

public interface UserService {

	public List<UserEntity> getAll();
	
	public UserEntity getOne(int id);

	public void insert(UserEntity user);

	public void update(UserEntity user);

	public void delete(int id);
}
