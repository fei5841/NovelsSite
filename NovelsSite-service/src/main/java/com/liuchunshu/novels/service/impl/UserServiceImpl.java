package com.liuchunshu.novels.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuchunshu.novels.dao.UserMapper;
import com.liuchunshu.novels.model.UserEntity;
import com.liuchunshu.novels.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<UserEntity> getAll() {
		return userMapper.getAll();
	}

	@Override
	public UserEntity getOne(int id) {
		return userMapper.getOne(id);
	}

	@Override
	public void insert(UserEntity user) {
		userMapper.insert(user);
	}

	@Override
	public void update(UserEntity user) {
		userMapper.update(user);
	}

	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}

}
