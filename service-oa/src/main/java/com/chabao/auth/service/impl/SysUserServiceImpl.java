package com.chabao.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chabao.auth.mapper.SysUserMapper;
import com.chabao.auth.service.SysUserService;
import com.chabao.model.system.SysUser;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chabao
 * @since 2023-07-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    //更新状态
    @Override
    public void updateStatus(Long id, Integer status) {
        //根据userid查询用户对象
        SysUser sysUser = baseMapper.selectById(id);
        //设置修改状态值
        sysUser.setStatus(status);
        //调用方法进行修改
        baseMapper.updateById(sysUser);
    }

}
