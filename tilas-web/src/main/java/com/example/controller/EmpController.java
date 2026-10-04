package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;


    @GetMapping
    public Result page(Integer page, Integer pageSize, Emp emp) {
        log.info("分页查询： page={}, pageSize={}, emp={}", page, pageSize, emp);
        PageResult<Emp> pageResult = empService.page(page, pageSize, emp);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工： {}", emp);
        empService.add(emp);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工： {}", emp);
        empService.update(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        log.info("删除员工： id={}", id);
        empService.delete(id);
        return Result.success();
    }

}