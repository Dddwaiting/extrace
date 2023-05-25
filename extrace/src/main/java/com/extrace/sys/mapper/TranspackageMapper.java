package com.extrace.sys.mapper;

import com.extrace.sys.entity.Transpackage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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
public interface TranspackageMapper extends BaseMapper<Transpackage> {

    @Select("SELECT tp.id, tn1.nodename AS sourceNodename, tn2.nodename AS targetNodename, tp.createTime, tp.status " +
            "FROM transpackage tp " +
            "JOIN transnode tn1 ON tp.sourceNode = tn1.id " +
            "JOIN transnode tn2 ON tp.targetNode = tn2.id")
    List<Map<String, Object>> getAllTransPackages();

}
