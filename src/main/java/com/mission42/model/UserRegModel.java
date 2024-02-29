package com.mission42.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegModel {
    @NotEmpty(message = "username should not Null and empty")
    @Size(min = 8, max = 12, message = "Username can not not less than 8 and not more than 12")
    private String userName;

    @NotEmpty(message = "Password can not be empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*_]).{8,}$", message = "Invalid Password")
    private String password;

    @NotEmpty(message = "Ip address can not empty")
    @Pattern(regexp = "^(((1?[1-9]?|10|2[0-4])\\d|25[0-5])($|\\.(?!$))){4}$", message = "Invalid Ip4 address")
    private String ip;
}
