package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.UserDemo;
import com.demo.service.UserDemoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserDemoController {

	@Autowired
	private UserDemoService userDemoService;

	@PostMapping
	public ResponseEntity<UserDemo> createUser(@RequestBody UserDemo userDemo) {

		UserDemo user = userDemoService.createUser(userDemo);
		return new ResponseEntity<UserDemo>(user, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDemo> getUserById(@PathVariable("id") Long id) {
		UserDemo user = userDemoService.findUserById(id);
		return new ResponseEntity<UserDemo>(user, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<UserDemo>> getAllUsers() {
		List<UserDemo> userDemoList = userDemoService.findAll();
		return new ResponseEntity<List<UserDemo>>(userDemoList, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserDemo> updateuser(@PathVariable("id") Long id, @RequestBody UserDemo user) {

		UserDemo userDemo = userDemoService.updateUserDemo(id, user);
		return new ResponseEntity<UserDemo>(userDemo, HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {

		userDemoService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted Successfully !!!", HttpStatus.OK);

	}
}
