package com.work.messaging.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.messaging.entity.pojo.SysUserRole;
import com.work.messaging.mapper.SysUserRoleMapper;
import com.work.messaging.service.SysUserRoleService;
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
 * @since 2019-10-29
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Override
    public List<SysUserRole> listByUserId(Integer userId) {
        QueryWrapper<SysUserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq("user_id",userId);
        return userRoleMapper.selectList(userRoleQueryWrapper);
    }
}
