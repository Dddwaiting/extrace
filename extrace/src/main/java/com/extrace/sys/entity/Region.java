package com.extrace.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RegionCode", type = IdType.AUTO)
    private String RegionCode;

    @TableField("Prv")
    private String Prv;

    @TableField("Cty")
    private String Cty;

    @TableField("Twn")
    private String Twn;

    @TableField("Stage")
    private Integer Stage;



}
