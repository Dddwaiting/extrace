package com.extrace.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.extrace.sys.entity.Userinfo;
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
 *
 */
@Mapper
public interface UserinfoMapper extends BaseMapper<Userinfo> {




    @Select("SELECT * FROM userinfo")
    List<Userinfo> getUserinfo();
}
