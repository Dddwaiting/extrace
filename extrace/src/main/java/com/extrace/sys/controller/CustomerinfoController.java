package com.extrace.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.extrace.common.vo.Result;
import com.extrace.sys.entity.Expressroute;
import com.extrace.sys.entity.Region;
import com.extrace.sys.mapper.CustomerinfoMapper;
import com.extrace.sys.entity.Customerinfo;
import com.extrace.sys.service.CustomerinfoService;
import com.extrace.sys.service.ExpressrouteService;
import com.extrace.sys.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@RestController
public class CustomerinfoController {

    @Autowired
    private CustomerinfoMapper customerinfoMapper;

    @Autowired
    private CustomerinfoService customerinfoService;

    @Autowired
    private RegionService regionService;


    @GetMapping("/all")
    public Result<List<Customerinfo>> getAllCust() {
        List<Customerinfo> list = customerinfoMapper.getAllCust();
        return Result.success(list, "查询成功");
    }

    @PostMapping("/customer")
    public Result<?> addUser(@RequestBody Customerinfo customerinfo){

        customerinfoService.save(customerinfo);
        return Result.success("新增用户成功");
    }

    @PutMapping("/customer")
    public Result<?> updateUser(@RequestBody Customerinfo customerinfo){
        customerinfoService.updateById(customerinfo);
        return Result.success("修改用户成功");
    }

    @GetMapping("customer/{id}")
    public Result<Customerinfo> getUserById(@PathVariable("id") Integer id){
        Customerinfo customerinfo = customerinfoService.getById(id);
        return Result.success(customerinfo);
    }


//删除不了有外键的
    @DeleteMapping("customer/{id}")
    public Result<Customerinfo> deleteUserById(@PathVariable("id") Integer id){
        Customerinfo customer = customerinfoService.getById(id);
        if (customer == null) {
            return Result.fail("用户不存在");
        }

        customerinfoService.removeById(id);
        return Result.success("删除用户成功");
    }


    //分页数据展示
    @GetMapping("/customer/list")
    public Result<Map<String,Object>> getUserList(@RequestParam(value = "Name",required = false) String Name,
                                                  @RequestParam(value = "TelCode",required = false) String TelCode,
                                                  @RequestParam(value = "pageNo",required = false) Long pageNo,
                                                  @RequestParam(value = "pageSize",required = false) Long pageSize){

        LambdaQueryWrapper<Customerinfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(Name), Customerinfo::getName, Name);
        wrapper.like(StringUtils.hasLength(TelCode), Customerinfo::getTelCode, TelCode);

        Page<Customerinfo> page = new Page<>(pageNo, pageSize);
        customerinfoService.page(page, wrapper);

        List<Customerinfo> records = page.getRecords();

        // 获取所有的regioncode
        List<String> regionCodes = records.stream()
                .map(Customerinfo::getRegioncode)
                .collect(Collectors.toList());

        // 根据regioncode查询对应的region记录
        List<Region> regions = regionService.list(new LambdaQueryWrapper<Region>()
                .in(Region::getRegionCode, regionCodes));

        // 构建以regioncode为键的region记录的映射
        Map<String, Region> regionMap = regions.stream()
                .collect(Collectors.toMap(Region::getRegionCode, Function.identity()));

        // 构建最终输出的数据
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Customerinfo customerinfo : records) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("name", customerinfo.getName());
            resultMap.put("postcode", customerinfo.getPostcode());
            resultMap.put("id", customerinfo.getID());
            resultMap.put("telCode", customerinfo.getTelCode());
            resultMap.put("department", customerinfo.getDepartment());
            resultMap.put("postcode", customerinfo.getPostcode());
            resultMap.put("regioncode", customerinfo.getRegioncode());
            resultMap.put("address", customerinfo.getAddress());
            Region region = regionMap.get(customerinfo.getRegioncode());
            if (region != null) {
                resultMap.put("Prv", region.getPrv());
                resultMap.put("City", region.getCty());
                resultMap.put("Twn", region.getTwn());
            }

            resultList.add(resultMap);
        }

        Map<String,Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", resultList);

        return Result.success(data);
    }

}


