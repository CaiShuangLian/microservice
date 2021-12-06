package com.csl.springcloud.controller;

import com.csl.springcloud.entities.Dept;
import com.csl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class FeignController {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping("/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @GetMapping("/{id}")
    public Dept queryById(@PathVariable("id")Long id){
        return deptClientService.get(id);
    }




}
