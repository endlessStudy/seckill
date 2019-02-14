package com.tearsmart.seckill.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @since 2018-12-09
 */
@TableName("miaosha_user")
@Data
@Accessors(chain = true)
public class MiaoshaUser extends Model<MiaoshaUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 手机号码
     */
    @NotNull
    private String phoneNumber;
    /**
     * 昵称
     */
    @NotNull
    private String nickname;

    /**
     * MD5(MD5(pass明文+固定salt) + 随机salt)
     */
    @NotNull
    private String password;

    private String salt;

    /**
     * 头像，云存储的ID
     */
    private String head;

    /**
     * 注册时间
     */
    private LocalDateTime registerDate;

    /**
     * 上蔟登录时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;


    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return null;
    }
}
