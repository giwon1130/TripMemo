package com.ig.tripmemo.repository;

import com.ig.tripmemo.repository.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Settings, Long> {
}