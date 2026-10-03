package com.example.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer job;
    private Integer salary;
    private String image;
    private LocalDateTime createTime;
    private Integer deptId;
    private LocalDateTime updateTime;
    private LocalDate entryTime;
}