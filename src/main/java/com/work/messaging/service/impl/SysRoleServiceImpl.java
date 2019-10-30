package com.work.messaging.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.messaging.entity.pojo.SysRole;
import com.work.messaging.mapper.SysRoleMapper;
import com.work.messaging.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbh
 * @since 2019-10-29
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public SysRole getByName(String roleName) {
        QueryWrapper<SysRole> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("name",roleName);
        return roleMapper.selectOne(roleQueryWrapper);
    }
}
