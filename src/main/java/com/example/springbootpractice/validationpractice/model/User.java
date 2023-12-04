package com.example.springbootpractice.validationpractice.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    @NotNull(message = "姓名不能為空")
    String name;
    @Email(message = "信箱格式錯誤")
    @NotNull(message = "信箱不能為空")
    String email;
    @DecimalMax(message = "年齡不能大於25", value = "25")
    @DecimalMin(message = "年齡不能小於15", value = "15")
    String age;



}
