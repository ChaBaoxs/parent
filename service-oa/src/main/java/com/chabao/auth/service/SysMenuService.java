package com.chabao.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chabao.model.system.SysMenu;
import com.chabao.vo.system.AssginMenuVo;
import com.chabao.vo.system.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author chabao
 * @since 2023-07-04
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findMenuByRoleId(Long roleId);

    void doAssign(AssginMenuVo assginMenuVo);

    List<SysMenu> findNodes();

    void removeMenuById(Long id);

    List<RouterVo> findUserMenuListByUserId(Long userId);

    List<String> findUserPermsByUserId(Long userId);
}
