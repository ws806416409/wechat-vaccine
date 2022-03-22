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
@TableName("vaccine")
public class VaccineEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 种类
     */
    @TableField("type")
    private String type;

    /**
     * 产品编码
     */
    @TableField("code")
    private String code;

    /**
     * 批号
     */
    @TableField("number")
    private Integer number;

    /**
     * 生产公司
     */
    @TableField("company")
    private String company;

    /**
     * 疫苗详情
     */
    @TableField("details")
    private String details;


}
