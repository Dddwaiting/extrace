package com.extrace.sys.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.List;

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
public class Customerinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer ID;
    private String Name;

    @TableField("TelCode")
    private String TelCode;
    private String Department;
    private String Regioncode;
    private String Address;
    private int Postcode;
    @TableLogic
    private  Integer deleted;
/*
    @TableField(exist = false)
    private List<Region> region;

    public List<com.extrace.sys.entity.Region> getRegion() {
        return region;
    }

    public void setRegion(List<com.extrace.sys.entity.Region> region) {
        this.region = region;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTelCode() {
        return TelCode;
    }

    public void setTelCode(String telCode) {
        TelCode = telCode;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getRegionCode() {
        return Regioncode;
    }

    public void setRegionCode(String regionCode) {
        Regioncode = regionCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPostCode() {
        return Postcode;
    }

    public void setPostCode(int postCode) {
        Postcode = postCode;
    }
*/
}
