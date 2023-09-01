package com.ig.tripmemo.service;

import com.ig.tripmemo.repository.SettingRepository;
import com.ig.tripmemo.repository.entity.Settings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SettingService {

    private final SettingRepository settingRepository;

    public List<Settings> getAllSettings() {
        return settingRepository.findAll();
    }

    public Optional<Settings> getSettingById(Long id) {
        return settingRepository.findById(id);
    }

    public Settings createSetting(Settings user) {
        return settingRepository.save(user);
    }

    public Settings updateSetting(Settings user) {
        return settingRepository.save(user);
    }

    public void deleteSetting(Long id) {
        settingRepository.deleteById(id);
    }
}