package com.chabao.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chabao.auth.service.SysRoleService;
import com.chabao.model.system.SysRole;
import com.chabao.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    //查询所有用户
    @GetMapping("/findAll")
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.success(list);
    }
}
