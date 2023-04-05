package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.UserDemo;

public interface UserDemoRepository extends JpaRepository<UserDemo, Long>{

}
