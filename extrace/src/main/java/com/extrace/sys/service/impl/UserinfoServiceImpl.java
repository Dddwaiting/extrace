package com.extrace.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.extrace.sys.mapper.UserinfoMapper;
import com.extrace.sys.entity.Userinfo;
import com.extrace.sys.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {
    @Autowired
    private RedisTemplate redisTemplate;




    @Override
    public Map<String,Object> login(Userinfo userinfo){

        LambdaQueryWrapper<Userinfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Userinfo::getName,userinfo.getName());
        wrapper.eq(Userinfo::getPwd,userinfo.getPwd());
        Userinfo loginUser = this.baseMapper.selectOne(wrapper);
        //结果不为空生成token,存入redis
        if(loginUser != null){
            String key = "user:" + UUID.randomUUID();

            //存入redis
            loginUser.setPwd(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);

            //返回数据
            Map<String,Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }

        return  null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        Object obj = redisTemplate.opsForValue().get(token);
        if(obj != null){
            Userinfo loginUser = JSON.parseObject(JSON.toJSONString(obj),Userinfo.class);
            Map<String,Object> data = new HashMap<>();
            data.put("username",loginUser.getName());

            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }





}

