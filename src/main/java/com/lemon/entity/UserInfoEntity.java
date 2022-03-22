package com.lemon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lemon
 * @since 2022-03-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_info")
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    @TableField("uid")
    private Integer uid;

    @TableField("real_name")
    private String realName;

    @TableField("id_card")
    private String idCard;

    @TableField("phone")
    private String phone;

    @TableField("sex")
    private String sex;

    @TableField("age")
    private Integer age;

    /**
     * 过敏史
     */
    @TableField("allergy")
    private String allergy;

    /**
     * 不良反应史
     */
    @TableField("adverse_reaction")
    private String adverseReaction;


}
