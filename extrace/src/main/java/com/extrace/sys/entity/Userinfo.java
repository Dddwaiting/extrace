package com.extrace.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableId(value = "UID", type = IdType.AUTO)

    private Integer uid;

    /**
     * 密码
     */
    @TableField("PWD")
    private String pwd;

    /**
     * 名字
     */
    @TableField("Name")
    private String Name;

    @TableField("URull")
    private Integer URull;

    /**
     * 电话
     */
    @TableField("TelCode")
    private String TelCode;

    /**
     * 状态
     */
    @TableField("Status")
    private Integer Status;

    /**
     * 部门Id
     */
    @TableField("DptID")
    private String DptID;

    /**
     * 接受包裹
     */
    @TableField("ReceivePackageID")
    private String ReceivePackageID;

    /**
     * 派送包裹
     */
    @TableField("DelivePackageID")
    private String DelivePackageID;

    /**
     * 转运包裹
     */
    @TableField("TransPackageID")
    private String TransPackageID;


    public String getName() {
        return Name;
    }

    public void setName(String Name) {

        this.Name = Name;
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }




    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }



    public Integer getURull() {
        return URull;
    }

    public void setURull(Integer uRull) {
        this.URull = uRull;
    }




    public String getTelCode() {
        return TelCode;
    }


    public void setTelCode(String telcode) {
        this.TelCode = telcode == null ? null : telcode.trim();
    }


    public Integer getStatus() {
        return Status;
    }


    public void setStatus(Integer status) {
        this.Status = Status;
    }


    public String getDptID() {
        return DptID;
    }


    public void setDptID(String dptid) {
        this.DptID = DptID == null ? null : dptid.trim();
    }

    public String getReceivePackageID() {
        return ReceivePackageID;
    }


    public void setReceivePackageID(String ReceivePackageID) {
        this.ReceivePackageID = ReceivePackageID == null ? null : ReceivePackageID.trim();
    }


    public String getDelivePackageID() {
        return DelivePackageID;
    }


    public void setDelivePackageID(String delivePackageID) {
        this.DelivePackageID = delivePackageID == null ? null : delivePackageID.trim();
    }


    public String getTransPackageID() {
        return TransPackageID;
    }


    public void setTransPackageID(String TransPackageID) {
        this.TransPackageID = TransPackageID == null ? null : TransPackageID.trim();
    }

}
