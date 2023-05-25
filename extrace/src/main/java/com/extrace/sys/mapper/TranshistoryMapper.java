package com.extrace.sys.mapper;

import com.extrace.sys.entity.Transhistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@Mapper
public interface TranshistoryMapper extends BaseMapper<Transhistory> {


    @Select("SELECT th.sn, th.packageid, tn1.nodename AS sourceNodename, tn2.nodename AS targetNodename, th.actTime, th.x, th.y " +
            "FROM transhistory th " +
            "JOIN transnode tn1 ON th.UIDfrom = tn1.id " +
            "JOIN transnode tn2 ON th.UIDto = tn2.id")
    List<Map<String, Object>> getAllTranshistory();
}
