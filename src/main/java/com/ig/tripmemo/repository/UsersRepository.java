package com.ig.tripmemo.repository;

import com.ig.tripmemo.repository.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Long> {
}