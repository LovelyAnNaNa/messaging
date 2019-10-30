package com.work.messaging.security;

import com.work.messaging.entity.pojo.SysRole;
import com.work.messaging.entity.pojo.SysUser;
import com.work.messaging.entity.pojo.SysUserRole;
import com.work.messaging.exception.UserLoginException;
import com.work.messaging.service.SysRoleService;
import com.work.messaging.service.SysUserRoleService;
import com.work.messaging.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: wbh
 * @Date: 2019/10/29 19:41
 * @Description:  负责用户登录
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserLoginException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //从数据库中取出用户信息
        SysUser userInfo = userService.getByName(username);

        //判断用户是否存在
        if(userInfo == null){
            throw new UserLoginException("用户名不存在");
        }

        //添加角色
        List<SysUserRole> userRoleList = userRoleService.listByUserId(userInfo.getId());
        if (userRoleList != null && userRoleList.size() > 0) {
            userRoleList.forEach(e -> {
                SysRole role = roleService.getById(e.getRoleId());
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
        }

        return new User(userInfo.getUsername(), userInfo.getPassword(),authorities);
    }
}
