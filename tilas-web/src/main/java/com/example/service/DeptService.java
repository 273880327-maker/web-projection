package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void deleteById(Integer id);

    //新增部门
    void add(Dept dept);

    Dept getById(Integer id);
}
