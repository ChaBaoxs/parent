package com.chabao.auth;

import com.chabao.auth.mapper.SysRoleMapper;
import com.chabao.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMpDemo1 {

    //mapper爆红因为使用SysRoleMapper接口动态创建对象，提示没找到，实际不影响使用，在SysRoleMapper加上@Repository解决
    @Autowired
    private SysRoleMapper mapper;

    @Test
    public void getAll(){
        List<SysRole> sysRoles = mapper.selectList(null);
        System.out.println(sysRoles);
    }

    @Test
    public void deleteId(){
        int sysRoles = mapper.deleteById(1);
        System.out.println(sysRoles);
    }

//    SysRole sysRole = new SysRole("2","2","2");
//    @Test
//    public void add(){
//        int insert = mapper.insert(sysRole);
//        System.out.println(insert);
//    }
}
