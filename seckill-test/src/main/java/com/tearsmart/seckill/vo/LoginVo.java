package com.tearsmart.seckill.vo;

import com.tearsmart.seckill.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 登录页面 vo对象
 * </p>
 * @author tear-smart
 * @date 2018-12-09
 */
public class LoginVo {
    /**
     * 手机号码
     */
    @NotNull
    @IsMobile(required = true)
    private String mobile;
    /**
     * 用户密码
     */
    @NotNull
    @Length(max = 32, message = "密码长度超出限制!")
    private String pwd;

    public LoginVo() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

