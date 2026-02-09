package com.example.day4lms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentRequestDto {
    @NotBlank(message = "Name can not be blank")
    private String name;

    @Min(value = 5, message = "Age can not be less than 5")
    @Max(value = 90, message = "Age can not be more than 90")
    private Integer age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email can not be blank")
    private String email;
}
