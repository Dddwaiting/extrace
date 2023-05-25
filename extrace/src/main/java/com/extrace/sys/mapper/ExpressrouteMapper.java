package com.extrace.sys.mapper;

import com.extrace.sys.entity.Expressroute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface ExpressrouteMapper extends BaseMapper<Expressroute> {
    @Select("SELECT * FROM Expressroute")
    List<Expressroute> getExpressroute();
    @Select("SELECT x,y FROM Expressroute where ExpressID like #{ExpressID}")
    List<Expressroute> getExpressroutexy(String ExpressID);
}
