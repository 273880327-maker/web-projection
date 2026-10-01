package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/depts")
    public Result list(){
        System.out.println("查询全部的部门数据");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }
}
