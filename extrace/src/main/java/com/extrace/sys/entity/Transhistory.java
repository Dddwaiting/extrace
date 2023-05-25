package com.extrace.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class Transhistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id号
     */
    @TableId(value = "SN", type = IdType.AUTO)
    private Integer sn;

    /**
     * 包裹Id
     */
    @TableField("PackageID")
    private String PackageID;

    /**
     * 接受时间
     */
    @TableField("ActTime")
    private Date ActTime;

    /**
     * 来源站点
     */
    @TableField("UIDFrom")
    private Integer UIDFrom;

    /**
     * 去向站点
     */
    @TableField("UIDTo")
    private Integer UIDTo;

    private Float x;

    private Float y;


}
