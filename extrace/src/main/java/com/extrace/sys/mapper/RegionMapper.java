package com.extrace.sys.mapper;

import com.extrace.sys.entity.Region;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RegionMapper extends BaseMapper<Region> {

    @Select("select * from region where RegionCode = #{RegionCode}")
    List<Region> selectByUid(String RegionCode);
    //   查询用户及其所有的订单
    @Select("select * from region")
    @Results(
            {
                    @Result(column = "Regioncode",property = "Regioncode"),
                    @Result(column = "Prv",property = "Prv"),
                    @Result(column = "Cty",property = "Cty"),
                    @Result(column = "Twn",property = "Twn"),
                    @Result(column = "Stage",property = "Stage"),
                    @Result(column = "Regioncode",property = "customerinfo",javaType = List.class,
                            many=@Many(select = "com.example.mapper.CustomerinfoMapper.selectByUid")
                    )
            }
    )
    List<Region> selectAllUserAndOrders();
}


