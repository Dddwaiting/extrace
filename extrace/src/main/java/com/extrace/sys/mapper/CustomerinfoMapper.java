package com.extrace.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.extrace.sys.entity.Customerinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.extrace.sys.entity.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@Mapper
public interface CustomerinfoMapper extends BaseMapper<Customerinfo> {

@Select("select  * from customerinfo")
    List<Customerinfo> getAllCust();
}
