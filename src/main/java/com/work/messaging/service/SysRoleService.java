package com.work.messaging.service;

import com.work.messaging.entity.pojo.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbh
 * @since 2019-10-29
 */
public interface SysRoleService extends IService<SysRole> {

    SysRole getByName(String roleName);
}
