package com.example.mapper;


import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> list(Emp emp);

    void insert(Emp emp);

}