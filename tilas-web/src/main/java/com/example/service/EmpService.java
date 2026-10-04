package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> page(Integer page, Integer pageSize, Emp emp);

    void add(Emp emp);

    void update(Emp emp);

    void delete(Integer id);
}