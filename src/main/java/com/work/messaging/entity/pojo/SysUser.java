package com.work.messaging.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.work.messaging.base.UserBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author wbh
 * @since 2019-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends UserBase<SysUser> {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名
     */
    @NotBlank(message = "登录名不能为空")
    private String username;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 头像
     */
    private String icon;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否锁定 0：不锁，1：锁
     */
    private Integer locked;

    /**
     * 是否管理员0：不是 ，1：是
     */
    private Integer isAdmin;

    /**
     * 代理id
     */
    private Integer agentId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 预留字段1
     */
    private String v1;

    /**
     * 预留字段2
     */
    private String v2;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String NICK_NAME = "nick_name";

    public static final String ICON = "icon";

    public static final String PASSWORD = "password";

    public static final String CREATE_TIME = "create_time";

    public static final String CREATE_ID = "create_id";

    public static final String UPDATE_TIME = "update_time";

    public static final String UPDATE_ID = "update_id";

    public static final String TEL = "tel";

    public static final String EMAIL = "email";

    public static final String LOCKED = "locked";

    public static final String IS_ADMIN = "is_admin";

    public static final String AGENT_ID = "agent_id";

    public static final String REMARKS = "remarks";

    public static final String V1 = "v1";

    public static final String V2 = "v2";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    
    public void validateParams() {
        //调用JSR303验证工具，校验参数
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<SysUser>> violations = validator.validate(this);
        Iterator<ConstraintViolation<SysUser>> iter = violations.iterator();
        if (iter.hasNext()) {
            //需要springmvc捕获全局异常
            throw new ConstraintViolationException(violations);
        }
    }

}
