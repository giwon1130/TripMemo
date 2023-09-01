package com.ig.tripmemo.repository.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ApiModel(description = "Details about the User")
public class Users {

    @ApiModelProperty(notes = "The unique ID of the user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "The username of the user")
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @ApiModelProperty(notes = "The email ID of the user")
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(unique = true)
    private String email;

    @ApiModelProperty(notes = "The password of the user")
    @NotBlank
    @Size(max = 120)
    private String password;

    @ApiModelProperty(notes = "The phone number of the user")
    @Size(max = 15)
    private String phoneNumber;

    @ApiModelProperty(notes = "The role of the user")
    private String role;  // Could be an Enum

    @ApiModelProperty(notes = "Is the user account active?")
    private boolean isActive;

    @ApiModelProperty(notes = "The time the user was created")
    private LocalDateTime createdAt;

    @ApiModelProperty(notes = "The time the user was last updated")
    private LocalDateTime updatedAt;

    // getters and setters
}