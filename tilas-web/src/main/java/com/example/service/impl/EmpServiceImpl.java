package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpExpr;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, Emp emp) {
        PageHelper.startPage(page, pageSize);

        Page<Emp> p = (Page<Emp>) empMapper.list(emp);

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional
    public void add(Emp emp) {
        empMapper.insert(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if (exprList != null && !exprList.isEmpty()) {
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
                empExprMapper.insert(expr);
            }
        }
    }

    @Override
    @Transactional
    public void update(Emp emp) {
        empMapper.updateById(emp);

        empExprMapper.deleteByEmpId(emp.getId());

        List<EmpExpr> exprList = emp.getExprList();
        if (exprList != null && !exprList.isEmpty()) {
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
                empExprMapper.insert(expr);
            }
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        empExprMapper.deleteByEmpId(id);
        empMapper.deleteById(id);
    }
}