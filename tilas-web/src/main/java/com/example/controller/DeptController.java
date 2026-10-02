package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部的部门数据");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }


    @DeleteMapping("/depts")
    //前端传递的请求参数名与服务器端方法形参一致
    public Result delete(@RequestParam Integer id){
        System.out.println("根据id删除部门" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门" + dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据ID查询部门" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("更新部门信息" + dept);
        deptService.update(dept);
        return Result.success();
    }
}
