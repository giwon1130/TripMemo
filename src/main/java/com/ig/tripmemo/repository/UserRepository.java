package com.ig.tripmemo.repository;

import com.ig.tripmemo.repository.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}