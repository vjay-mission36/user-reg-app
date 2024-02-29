package com.mission42.controller;

import com.mission42.dto.UserWelcomeMsgDTO;
import com.mission42.model.UserRegModel;
import com.mission42.service.UserRegService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-reg")
public class UserRegistrationController {
    @Autowired
    UserRegService userRegService;

    @GetMapping
    public ResponseEntity<UserWelcomeMsgDTO> registerUser(@Valid @RequestBody UserRegModel userRegModel) {
        UserWelcomeMsgDTO userWelcomeMsgDTO = userRegService.registerUser(userRegModel);
        return ResponseEntity.ok(userWelcomeMsgDTO);
    }
}
