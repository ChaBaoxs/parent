package com.chabao.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chabao.model.system.SysUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author chabao
 * @since 2023-07-03
 */
public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);

    SysUser getUserByUserName(String username);
}
