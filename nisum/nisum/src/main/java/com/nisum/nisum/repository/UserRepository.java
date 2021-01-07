package com.nisum.nisum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.nisum.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
