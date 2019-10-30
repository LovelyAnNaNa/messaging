package com.work.messaging.service;

import com.work.messaging.entity.pojo.SysMenu;
import com.work.messaging.entity.pojo.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbh
 * @since 2019-10-30
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    List<SysRoleMenu> listByRoleId(Integer roleId);
}
