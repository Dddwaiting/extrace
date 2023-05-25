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
public class Expresssheet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快件Id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    /**
     * 快件类型
     */
    @TableField("Type")
    private Integer Type;

    /**
     * 发送者
     */
    @TableField("Sender")
    private Integer Sender;

    /**
     * 接收者
     */
    @TableField("Recever")
    private Integer Recever;

    /**
     * 重量
     */
    @TableField("Weight")
    private Float Weight;

    /**
     * 运输费用
     */
    @TableField("TranFee")
    private Float TranFee;

    /**
     * 包裹费用
     */
    @TableField("PackageFee")
    private Float PackageFee;

    @TableField("InsuFee")
    private Float InsuFee;

    /**
     * 快递从业员
     */
    @TableField("Accepter")
    private String Accepter;

    /**
     * 派送从业员
     */
    @TableField("Deliver")
    private String Deliver;

    /**
     * 接受时间
     */
    @TableField("AccepteTime")
    private Date AccepteTime;

    /**
     * 派送时间
     */
    @TableField("DeliveTime")
    private Date DeliveTime;

    @TableField("Acc1")
    private String Acc1;

    @TableField("Acc2")
    private String Acc2;

    /**
     * 状态
     */
    @TableField("Status")
    private Integer Status;


}
