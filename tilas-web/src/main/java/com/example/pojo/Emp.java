package com.example.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private String deptName;
    private LocalDateTime updateTime;
    private LocalDate entryDate;
    private LocalDate entryDateStart;
    private LocalDate entryDateEnd;
    private List<EmpExpr> exprList;
}