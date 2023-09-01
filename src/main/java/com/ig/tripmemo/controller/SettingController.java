package com.ig.tripmemo.controller;

import com.ig.tripmemo.common.ApiResponse;
import com.ig.tripmemo.repository.entity.Settings;
import com.ig.tripmemo.service.SettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Setting Management System")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/setting")
public class SettingController {


    // 테스트
    private final SettingService settingService;

    @ApiOperation(value = "View a list of available settings", response = List.class)
    @GetMapping("/")
    public ApiResponse<List<Settings>> getAllSettings() {
        return ApiResponse.setSuccessOkResponse(settingService.getAllSettings());
    }

    @ApiOperation(value = "Get a settings by Id")
    @GetMapping("/{id}")
    public ApiResponse<Settings> getSettingById(@PathVariable Long id) {
        Optional<Settings> settings = settingService.getSettingById(id);
        if (settings.isPresent()) {
            return ApiResponse.setSuccessOkResponse(settings.get());
        } else {
            return ApiResponse.setNotFoundResponse();
        }
    }

    @ApiOperation(value = "Add a settings")
    @PostMapping("/")
    public ApiResponse<Settings> createSetting(@RequestBody Settings settings) {
        return ApiResponse.setSuccessCreatedResponse(settingService.createSetting(settings));
    }

    @ApiOperation(value = "Update a settings")
    @PutMapping("/{id}")
    public ApiResponse<Settings> updateSetting(@PathVariable Long id, @RequestBody Settings settings) {
        settings.setId(id);
        return ApiResponse.setSuccessOkResponse(settingService.updateSetting(settings));
    }

    @ApiOperation(value = "Delete a settings")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteSetting(@PathVariable Long id) {
        settingService.deleteSetting(id);
        return ApiResponse.setSuccessOkResponse(null);
    }
}

