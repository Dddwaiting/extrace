package com.extrace.sys.controller;


import com.extrace.common.vo.Result;
import com.extrace.sys.entity.Customerinfo;
import com.extrace.sys.entity.Expressroute;
import com.extrace.sys.mapper.ExpressrouteMapper;
import com.extrace.sys.service.ExpressrouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

public class ExpressrouteController {
    @Autowired
    private ExpressrouteMapper expressrouteMapper;

    @Autowired
    private ExpressrouteService expressrouteService;

    @GetMapping("/test2")
    public Result<List<Expressroute>> getExpressroute() {
        List<Expressroute> List = expressrouteMapper.getExpressroute();
        return  Result.success(List); //
    }



    @GetMapping("customer/map/{ExpressID}")
    public Result<List<Map<String, Double>>> getExpressroutexy(@PathVariable("ExpressID") String ExpressID) {
        List<Expressroute> expressrouteList = expressrouteMapper.getExpressroutexy(ExpressID);
        List<Map<String, Double>> result = new ArrayList<>();

        for (Expressroute expressroute : expressrouteList) {
            Map<String, Double> coordinates = new HashMap<>();
            coordinates.put("lat", expressroute.getX());
            coordinates.put("lng", expressroute.getY());
            result.add(coordinates);
        }

        return Result.success(result);
    }


    @GetMapping("customer/map2/{id}")
    public Result<Expressroute> getUserById(@PathVariable("ExpressID") String ExpressID){
        Expressroute expressroute = expressrouteService.getById(ExpressID);
        return Result.success(expressroute);
    }
}

