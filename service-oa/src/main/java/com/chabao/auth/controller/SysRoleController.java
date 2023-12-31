package com.chabao.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chabao.auth.service.SysRoleService;
import com.chabao.common.config.exception.ChaBaoException;
import com.chabao.model.system.SysRole;
import com.chabao.result.Result;
import com.chabao.vo.system.AssginRoleVo;
import com.chabao.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    //查询所有用户
    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
//        try {
//            int i = 10/0;
//        }catch (Exception e){
//            throw new ChaBaoException(33,"自定义异常");
//        }
        return Result.success(list);
    }

    /**
     * 条件分页查询
     * @param page 当前页
     * @param limit 每页显示记录
     * @param sysRoleQueryVo 条件对象
     * @return
     */
    //@PreAuthorize检查是否有此权限
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo){
        Page pageParam = new Page<>(page,limit);
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)){
            wrapper.like(SysRole::getRoleName,roleName);
        }
//        Page page1 = sysRoleService.page(pageParam, wrapper);
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
        return Result.success(pageModel);
    }

    //添加角色
    @PreAuthorize("hasAuthority('bnt.sysRole.add')")
    @ApiOperation("添加角色")
//    @GetMapping("/save") @GetMapping方式不含请求体，不能使用@RequestBody通过请求体json格式传递参数
    @PostMapping("/save")
    public Result save(@RequestBody SysRole sysRole){
        boolean is_success = sysRoleService.save(sysRole);
        if (is_success){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    //修改角色-根据id查询
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.success(sysRole);
    }

    //修改角色-最终修改
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
    @ApiOperation("修改角色")
    @PutMapping ("update")
    public Result update(@RequestBody SysRole role) {
        //调用service的方法
        boolean is_success = sysRoleService.updateById(role);
        if(is_success) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    //根据id删除
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        boolean is_success = sysRoleService.removeById(id);
        if(is_success) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    //批量删除
    // 前端数组 [1,2,3]
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        boolean is_success = sysRoleService.removeByIds(idList);
        if(is_success) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    //1 查询所有角色 和 当前用户所属角色
    @ApiOperation("获取角色")
    @GetMapping("/toAssign/{userId}")
    public Result toAssign(@PathVariable Long userId) {
        Map<String,Object> map = sysRoleService.findRoleDataByUserId(userId);
        return Result.success(map);
    }

    //2 为用户分配角色
    @ApiOperation("为用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.success();
    }

}
