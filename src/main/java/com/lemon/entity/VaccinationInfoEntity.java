package com.lemon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("vaccination_info")
public class VaccinationInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    @TableField("vid")
    private Integer vid;

    @TableField("place")
    private String place;

    /**
     * 接种地开放接种时间
     */
    @TableField("vtime")
    private LocalDateTime vtime;

    /**
     * 剩余剂量
     */
    @TableField("dose")
    private String dose;

    /**
     * 排队人数
     */
    @TableField("rank")
    private String rank;


}
