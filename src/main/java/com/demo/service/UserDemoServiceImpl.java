package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.entity.UserDemo;
import com.demo.exception.UserCustomException;
import com.demo.repository.UserDemoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDemoServiceImpl implements UserDemoService {

	@Autowired
	private UserDemoRepository userDemoRepository;

	@Override
	public UserDemo createUser(UserDemo userDemo) {

		UserDemo user = userDemoRepository.save(userDemo);
		return user;
	}

	@Override
	public UserDemo findUserById(Long id) {

		UserDemo optionalUser = userDemoRepository.findById(id).
				orElseThrow(() -> new UserCustomException("Data Not Found for Id :" + id, "User Id Not Found"));
		return optionalUser;
	}

	@Override
	public List<UserDemo> findAll() {

		List<UserDemo> userDemo = userDemoRepository.findAll();
		return userDemo;
	}

	@Override
	public UserDemo updateUserDemo(Long id, UserDemo user) {

		Optional<UserDemo> userDemo = userDemoRepository.findById(id);

		UserDemo users = userDemo.get();

		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setEmail(user.getEmail());

		UserDemo userObj = userDemoRepository.save(users);

		return userObj;
	}

	@Override
	public void deleteUser(Long id) {
		userDemoRepository.deleteById(id);
		
	}

}
