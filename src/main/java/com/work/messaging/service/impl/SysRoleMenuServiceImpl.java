package com.work.messaging.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.messaging.entity.pojo.SysMenu;
import com.work.messaging.entity.pojo.SysRoleMenu;
import com.work.messaging.mapper.SysRoleMenuMapper;
import com.work.messaging.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbh
 * @since 2019-10-30
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper roleMenuMapper;

    @Override
    public List<SysRoleMenu> listByRoleId(Integer roleId) {
        QueryWrapper<SysRoleMenu> roleMenuQueryWrapper = new QueryWrapper<>();
        roleMenuQueryWrapper.eq("role_id",roleId);
        return roleMenuMapper.selectList(roleMenuQueryWrapper);
    }
}
