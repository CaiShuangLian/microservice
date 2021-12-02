package com.csl.springcloud.service.impl;

import com.csl.springcloud.dao.DeptDao;
import com.csl.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csl.springcloud.service.DeptService;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao ;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }


    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }


    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }
}
