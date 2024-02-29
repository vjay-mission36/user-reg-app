package com.mission42.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IPRestAPIResponse {
    private String status;
    private String country;
    private String countryCode;
    private String city;
}
