package com.liuchunshu.novels.dao;

import java.util.List;

import com.liuchunshu.novels.model.UserEntity;

public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(int id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(int id);

}