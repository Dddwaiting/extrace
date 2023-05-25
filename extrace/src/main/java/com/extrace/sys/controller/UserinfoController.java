package com.extrace.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.extrace.common.vo.Result;
import com.extrace.sys.entity.Userinfo;
import com.extrace.sys.mapper.UserinfoMapper;
import com.extrace.sys.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@RestController

//@RequestMapping("/userinfo")
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private UserinfoMapper userinfoMapper;



    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody Userinfo userinfo) {
        Map<String, Object> data = userinfoService.login(userinfo);

        if (data != null) {
            return Result.success(data);
        }
        return Result.fail(20002, "用户名或者密码错误");
    }

    @GetMapping("info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token) {
        //根据token获取用户信息在redis中
        Map<String, Object> data = userinfoService.getUserInfo(token);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail(20003, "登录信息无效，请重新登录");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token) {
        userinfoService.logout(token);
        return Result.success("注销成功");
    }


      @GetMapping("/customer/user1")
      public Result<List<Userinfo>> getAllUserinfo() {

          List<Userinfo> list=  userinfoService.list();
          if (!list.isEmpty()) {
              return Result.success(list, "查询成功！");
          } else {
              return Result.fail("查询失败！");
          }
      }
    @GetMapping("/customer/user")
    public Result<List<Userinfo>> getUserinfo() {
        List<Userinfo> userList = userinfoMapper.getUserinfo();
        return  Result.success(userList); //
    }




 /* @GetMapping("/customer/user")
    public Result<Map<String, Object>> seachUserinfo(

            @RequestParam(value = "pageNo") long pageNo, // 从请求参数中获取 pageNo
            @RequestParam(value = "pageSize") long pageSize // 从请求参数中获取 pageSize
    ) {
        LambdaQueryWrapper<Userinfo> wrapper = new LambdaQueryWrapper<>(); // 创建 LambdaQueryWrapper 对象，用于构建查询条件



     // IPage<Map<String, Object>> page  = userinfoService.pageMaps(new Page<>(pageNo,pageSize), wrapper);


        Page<Userinfo> page = new Page<>(pageNo, pageSize); // 创建 Page 对象，指定当前页码和每页记录数
        userinfoService.page(page, wrapper); // 调用 userinfoService 的分页查询方法，传入分页参数和查询条件

        Map<String, Object> data = new HashMap<>(); // 创建一个 Map 对象，用于存储查询结果和分页信息
        data.put("total", page.getTotal()); // 将总记录数放入 Map 中
        data.put("row", page.getRecords()); // 将查询到的用户信息列表放入 Map 中


        return Result.success(data); // 返回一个成功的结果对象，其中 data 是查询结果的封装
    }



    @Autowired
    public UserinfoController(UserinfoService userinfoService) {
        this.userinfoService = userinfoService;
    }
    @GetMapping("/getUserinfo")
    public resultWithpage<Userinfo> getPageInfo(@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
                                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {



        return  new resultWithpage<>(userinfoService.getPageInfo(pageNo, pageSize));
    }

 @GetMapping("/customer/findAll")
 public Result<Map<String,Object>> getUserList(@RequestParam(value = "name",required = false) String Name,

                                               @RequestParam(value = "pageNo",required = false) Long pageNo,
                                               @RequestParam(value = "pageSize",required = false) Long pageSize){

     LambdaQueryWrapper<Userinfo> wrapper = new LambdaQueryWrapper<>();
     wrapper.eq(StringUtils.hasLength(Name),Userinfo::getName,Name);



     Page<Userinfo> page = new Page<>(pageNo,pageSize);
     userinfoService.page(page,wrapper);

     Map<String,Object> data = new HashMap<>();
     data.put("total",page.getTotal());
     data.put("rows",page.getRecords());

     return Result.success(data);

 }
 */

}



