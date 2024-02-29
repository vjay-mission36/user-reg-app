package com.mission42.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWelcomeMsgDTO {
    private String uuid;
    private String welcomeMsg;
}
