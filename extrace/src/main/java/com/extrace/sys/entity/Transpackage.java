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
public class Transpackage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id号
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    /**
     * 来源站点
     */
    @TableField("SourceNode")
    private String SourceNode;

    /**
     * 目标站点
     */
    @TableField("TargetNode")
    private String TargetNode;

    /**
     * 创造时间
     */
    @TableField("CreateTime")
    private Date CreateTime;

    /**
     * 状态
     */
    @TableField("Status")
    private Integer Status;



}
