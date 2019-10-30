package com.work.messaging.service;

import com.work.messaging.entity.pojo.SysUserRole;
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
public interface SysUserRoleService extends IService<SysUserRole> {

    List<SysUserRole> listByUserId(Integer userId);
}
