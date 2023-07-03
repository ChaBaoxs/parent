package com.chabao.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chabao.auth.mapper.SysRoleMapper;
import com.chabao.auth.service.SysRoleService;
import com.chabao.model.system.SysRole;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
