package com.logisticsportal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private String name;
    private String email;
    private String contact;
    private String role;
}
