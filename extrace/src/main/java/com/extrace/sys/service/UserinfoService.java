package com.extrace.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.extrace.sys.entity.Userinfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
public interface UserinfoService extends IService<Userinfo> {



    Map<String, Object> login(Userinfo userinfo);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);



}
