package com.work.messaging.service;

import com.work.messaging.entity.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbh
 * @since 2019-10-29
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getByName(String username);
}
