package com.harsh.ass.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.ass.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
