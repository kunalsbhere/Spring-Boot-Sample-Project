package com.demo.service;

import java.util.List;

import com.demo.entity.UserDemo;

public interface UserDemoService {

	UserDemo createUser(UserDemo userDemo);

	UserDemo findUserById(Long id);

	List<UserDemo> findAll();

	UserDemo updateUserDemo(Long id, UserDemo user);

	void deleteUser(Long id);
}
